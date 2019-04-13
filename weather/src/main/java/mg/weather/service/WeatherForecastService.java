package mg.weather.service;

import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.weather.WeatherConfiguration;
import mg.weather.converter.WeatherForecastDTOToEntity;
import mg.weather.converter.WeatherForecastEntityToDTO;
import mg.weather.dbentity.WeatherForecastDBEntity;
import mg.weather.model.WeatherForecast;
import mg.weather.repository.WeatherForecastRepository;
import mg.weather.util.WeatherUrlBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableConfigurationProperties(WeatherConfiguration.class)
public class WeatherForecastService {

    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    WeatherUrlBuilder weatherUrlBuilder;
    @Autowired
    WeatherForecastRepository weatherForecastRepository;
    @Autowired
    WeatherConfiguration weatherConfiguration;
    @Autowired
    WeatherForecastDTOToEntity weatherForecastDTOToEntity;
    @Autowired
    WeatherForecastEntityToDTO weatherForecastEntityToDTO;

    public List<WeatherForecast> getDefaultWeatherForecast() {
        return getWeatherForecastByCityName(weatherConfiguration.getDefaultCity());
    }

    public List<WeatherForecast> getWeatherForecastByCityName(String cityName) {
        List<WeatherForecastDBEntity> weatherForecastList = new ArrayList<>();
        boolean expired = true;
        if (weatherForecastRepository.findAllByCityName(cityName).size() > 0) {
            weatherForecastList = weatherForecastRepository.findAllByCityName(cityName);
            expired = weatherForecastList.get(0).getTime().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear();
        }
        if (weatherForecastList.size() == 0 || weatherForecastList.get(0) == null || expired) {
            updateWeatherForecastByCityName(cityName);
            weatherForecastList = weatherForecastRepository.findAllByCityName(cityName);
        }
        return weatherForecastList.stream()
                .map(weatherForecastEntityToDTO::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateDefaultWeatherForecast() {
        updateWeatherForecastByCityName(weatherConfiguration.getDefaultCity());
    }

    public void updateWeatherForecastByCityName(String cityName) {
        JSONObject currentWeatherJson = jsonConsumer.getJsonObject(weatherUrlBuilder.buildForecastUrl(cityName));
        weatherForecastRepository.deleteAllByCityName(cityName);
        saveWeatherForecastEntities(currentWeatherJson);
    }

    private void saveWeatherForecastEntities(JSONObject json) {
        List<WeatherForecastDBEntity> dbList = new ArrayList<>();
        JSONArray forecasts = json.getJSONArray("list");
        String city = jsonHelper.getString(json, "city.name").toLowerCase();
        int numberOfRecords = json.getInt("cnt");
        for (int i = 0; i < numberOfRecords; i++){
            WeatherForecastDBEntity dbEntity = new WeatherForecastDBEntity();
            JSONObject forecast = forecasts.getJSONObject(i);
            dbEntity.setTime(jsonHelper.getTimestampOfEpochSecond(forecast, "dt"));
            dbEntity.setTemperature(jsonHelper.getDouble(forecast, "main.temp"));
            dbEntity.setMinimalTemperature(jsonHelper.getDouble(forecast, "main.temp_min"));
            dbEntity.setMaximumTemperature(jsonHelper.getDouble(forecast, "main.temp_max"));
            dbEntity.setPressure(jsonHelper.getDouble(forecast, "main.pressure"));
            dbEntity.setSeaLevel(jsonHelper.getDouble(forecast, "main.sea_level"));
            dbEntity.setGroundLevel(jsonHelper.getDouble(forecast, "main.grnd_level"));
            dbEntity.setHumidity(jsonHelper.getDouble(forecast, "main.humidity"));
            dbEntity.setMainInfo(jsonHelper.getString(forecast, "weather[0].main"));
            dbEntity.setDescription(jsonHelper.getString(forecast, "weather[0].description"));
            dbEntity.setIcon(jsonHelper.getString(forecast, "weather[0].icon"));
            dbEntity.setWindSpeed(jsonHelper.getDouble(forecast, "wind.speed"));
            dbEntity.setWindDegree(jsonHelper.getDouble(forecast, "wind.deg"));
            dbEntity.setCityName(city);
            dbEntity.setUpdateTime(Timestamp.from(Instant.now()));
            dbEntity = weatherForecastRepository.save(dbEntity);
            dbList.add(dbEntity);
        }
    }

}
