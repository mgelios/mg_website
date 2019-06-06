package mg.weather.service;

import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.weather.WeatherConfiguration;
import mg.weather.dbentity.WeatherForecastDBEntity;
import mg.weather.mapper.WeatherForecastMapper;
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
@Transactional
public class WeatherForecastService {

    @Autowired
    private JSONHelper jsonHelper;
    @Autowired
    private JSONConsumer jsonConsumer;
    @Autowired
    private WeatherUrlBuilder weatherUrlBuilder;
    @Autowired
    private WeatherForecastRepository weatherForecastRepository;
    @Autowired
    private WeatherConfiguration weatherConfiguration;

    public List<WeatherForecast> getDefaultWeatherForecast() {
        return getWeatherForecastByCityName(weatherConfiguration.getDefaultCity());
    }

    public List<WeatherForecast> getWeatherForecastByCityName(String cityName) {
        List<WeatherForecastDBEntity> weatherForecastList = new ArrayList<>();
        boolean expired = true;
        if (weatherForecastRepository.findAllByCityName(cityName).size() > 0) {
            weatherForecastList = weatherForecastRepository.findAllByCityName(cityName);
            expired = weatherForecastList.get(0).getTime().toLocalDateTime().getHour() != LocalDateTime.now().getHour();
        }
        if (weatherForecastList.size() == 0 || weatherForecastList.get(0) == null || expired) {
            weatherForecastList = updateWeatherForecastByCityName(cityName);
        }
        return weatherForecastList.stream()
                .map(WeatherForecastMapper.INSTANCE::mapToDTO)
                .collect(Collectors.toList());
    }

    public void updateDefaultWeatherForecast() {
        updateWeatherForecastByCityName(weatherConfiguration.getDefaultCity());
    }

    public List<WeatherForecastDBEntity> updateWeatherForecastByCityName(String cityName) {
        JSONObject currentWeatherJson = jsonConsumer.getJsonObject(weatherUrlBuilder.buildForecastUrl(cityName));
        if (weatherForecastRepository.findAllByCityName(cityName).size() != 0) {
            weatherForecastRepository.deleteAllByCityName(cityName);
        }
        return saveWeatherForecastEntities(currentWeatherJson);
    }

    private List<WeatherForecastDBEntity> saveWeatherForecastEntities(JSONObject json) {
        List<WeatherForecastDBEntity> result = new ArrayList<>();
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
            result.add(dbEntity);
        }
        return result;
    }

}
