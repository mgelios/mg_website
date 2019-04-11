package mg.weather.services;

import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.weather.WeatherConfiguration;
import mg.weather.converters.CurrentWeatherEntityToDTO;
import mg.weather.converters.CurrentWeatherDTOToEntity;
import mg.weather.converters.WeatherForecastEntityToDTO;
import mg.weather.converters.WeatherForecastDTOToEntity;
import mg.weather.dbentities.CurrentWeatherDBEntity;
import mg.weather.dbentities.WeatherForecastDBEntity;
import mg.weather.models.CurrentWeather;
import mg.weather.models.WeatherForecast;
import mg.weather.repositories.CurrentWeatherRepository;
import mg.weather.repositories.CurrentWeatherDAO;
import mg.weather.repositories.WeatherForecastRepository;
import mg.weather.utils.WeatherUrlBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableConfigurationProperties(WeatherConfiguration.class)
public class BasicWeatherService implements WeatherService {

    @Autowired
    CurrentWeatherRepository currentWeatherRepository;

    @Autowired
    WeatherForecastRepository weatherForecastRepository;

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Autowired
    WeatherUrlBuilder weatherUrlBuilder;

    @Autowired
    JSONConsumer jsonConsumer;

    @Autowired
    JSONHelper jsonHelper;

    @Autowired
    CurrentWeatherEntityToDTO currentWeatherEntityToDTO;

    @Autowired
    CurrentWeatherDTOToEntity currentWeatherDTOToEntity;

    @Autowired
    WeatherForecastEntityToDTO weatherForecastEntityToDTO;

    @Autowired
    WeatherForecastDTOToEntity weatherForecastDTOToEntity;

    @Autowired
    CurrentWeatherDAO currentWeatherDAO;

    @Override
    public CurrentWeather getDefaultWeatherInfo(){
        return getWeatherInfo(weatherConfiguration.getDefaultCity());
    }

    @Override
    public List<WeatherForecast> getDefaultWeatherForecast(){
        return getWeatherForecast(weatherConfiguration.getDefaultCity());
    }

    public CurrentWeather getWeatherInfo(String cityName) {
        CurrentWeatherDBEntity dbEntity = null;
        if (currentWeatherRepository.findByCityName(cityName).isPresent()) {
            dbEntity = currentWeatherRepository.findByCityName(cityName).get();
            int dbCurrentWeatherHours = dbEntity.getTime().toLocalDateTime().getHour() / 2;
            int currentTimeHours = LocalDateTime.now().getHour() / 2;
            if (currentTimeHours != dbCurrentWeatherHours) {
                currentWeatherRepository.delete(dbEntity);
                dbEntity = writeCurrentWeatherToDBEntity(cityName);
            }
        } else {
            dbEntity = writeCurrentWeatherToDBEntity(cityName);
            currentWeatherRepository.save(dbEntity);
            dbEntity = currentWeatherRepository.findByCityName("minsk").get();
        }
        //List<CurrentWeatherDBEntity> searchedEntities = currentWeatherDAO.searchCurrentWeather("ins", "ear");
        return currentWeatherEntityToDTO.convert(dbEntity);
    }

    public List<WeatherForecast> getWeatherForecast(String cityName){
        List<WeatherForecast> forecastRecords = new ArrayList<>();
        if (weatherForecastRepository.findByCityName(cityName).isPresent()){
            WeatherForecastDBEntity dbEntity = weatherForecastRepository.findByCityName(cityName).get();
            int dbWeatherForecast = dbEntity.getTime().toLocalDateTime().getHour() / 2;
            int currentTimeHours = LocalDateTime.now().getHour() / 2;
            if (currentTimeHours != dbWeatherForecast) {
                weatherForecastRepository.deleteAllByCityName(cityName);
                forecastRecords = writeWeatherForecastToDBEntity(cityName).stream()
                        .map(weatherForecastEntityToDTO::convert)
                        .collect(Collectors.toList());
            }
        } else {
            forecastRecords = writeWeatherForecastToDBEntity(cityName).stream()
                    .map(weatherForecastEntityToDTO::convert)
                    .collect(Collectors.toList());
        }
        return forecastRecords;
    }

    private CurrentWeatherDBEntity writeCurrentWeatherToDBEntity(String cityName){
        JSONObject json = jsonConsumer.getJsonObject(weatherUrlBuilder.buildCurrentWeatherUrl(cityName));
        CurrentWeatherDBEntity dbEntity = new CurrentWeatherDBEntity();
        dbEntity.setLatitude(jsonHelper.getDouble(json, "coord.lat"));
        dbEntity.setLongitude(jsonHelper.getDouble(json, "coord.lon"));
        dbEntity.setDescription(jsonHelper.getString(json, "weather[0].description"));
        dbEntity.setMainInfo(jsonHelper.getString(json, "weather[0].main"));
        dbEntity.setIcon(jsonHelper.getString(json, "weather[0].icon"));
        dbEntity.setTemperature(jsonHelper.getDouble(json, "main.temp"));
        dbEntity.setPressure(jsonHelper.getDouble(json, "main.pressure"));
        dbEntity.setHumidity(jsonHelper.getDouble(json, "main.humidity"));
        dbEntity.setMinimalTemperature(jsonHelper.getDouble(json, "main.temp_min"));
        dbEntity.setMaximumTemperature(jsonHelper.getDouble(json, "main.temp_max"));
        dbEntity.setVisibility(jsonHelper.getDouble(json,"visibility"));
        dbEntity.setWindSpeed(jsonHelper.getDouble(json,"wind.speed"));
        dbEntity.setWindDegree(jsonHelper.getDouble(json,"wind.deg"));
        dbEntity.setTime(jsonHelper.getTimestampOfEpochSecond(json, "dt"));
        dbEntity.setSunrise(jsonHelper.getTimestampOfEpochSecond(json, "sys.sunrise"));
        dbEntity.setSunset(jsonHelper.getTimestampOfEpochSecond(json, "sys.sunset"));
        dbEntity.setCityName(jsonHelper.getString(json,"name").toLowerCase());
        return dbEntity;
    }

    private List<WeatherForecastDBEntity> writeWeatherForecastToDBEntity(String cityName){
        List<WeatherForecastDBEntity> dbList = new ArrayList<>();
        JSONObject json = jsonConsumer.getJsonObject(weatherUrlBuilder.buildForecastUrl(cityName));
        JSONArray forecasts = json.getJSONArray("list");
        String city = jsonHelper.getString(json, "city.name");
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
            dbList.add(dbEntity);
        }
        return dbList;
    }

}
