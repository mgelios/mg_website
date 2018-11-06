package mg.weather.services;

import mg.utils.JSONConsumer;
import mg.weather.WeatherConfiguration;
import mg.weather.converters.CurrentWeatherDBEntityToCurrentWeather;
import mg.weather.converters.CurrentWeatherToCurrentWeatherDBEntity;
import mg.weather.dbentities.CurrentWeatherDBEntity;
import mg.weather.dbentities.WeatherForecastDBEntity;
import mg.weather.models.CurrentWeather;
import mg.weather.models.WeatherForecast;
import mg.weather.repositories.CurrentWeatherRepository;
import mg.weather.utils.WeatherUrlBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BasicWeatherService implements WeatherService {

    @Autowired
    CurrentWeatherRepository currentWeatherRepository;

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Autowired
    WeatherUrlBuilder weatherUrlBuilder;

    @Autowired
    JSONConsumer jsonConsumer;

    @Autowired
    CurrentWeatherDBEntityToCurrentWeather currentWeatherDBEntityToCurrentWeather;

    @Autowired
    CurrentWeatherToCurrentWeatherDBEntity currentWeatherToCurrentWeatherDBEntity;

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
                dbEntity = writeCurrentWeatherToDB(cityName);
            }
        } else {
            dbEntity = writeCurrentWeatherToDB(cityName);
            currentWeatherRepository.save(dbEntity);
            dbEntity = currentWeatherRepository.findByCityName("minsk").get();
        }
        return currentWeatherDBEntityToCurrentWeather.convert(dbEntity);
    }

    public List<WeatherForecast> getWeatherForecast(String cityName){
        List<WeatherForecast> forecastRecords = new ArrayList<>();
        writeWeatherForecastToDB(cityName);
        return null;
    }

    private CurrentWeatherDBEntity writeCurrentWeatherToDB(String cityName){
        JSONObject json = jsonConsumer.getJson(weatherUrlBuilder.buildCurrentWeatherUrl(cityName));
        CurrentWeatherDBEntity dbEntity = new CurrentWeatherDBEntity();
        dbEntity.setLatitude(Double.valueOf(((JSONObject)json.get("coord")).get("lat").toString()));
        dbEntity.setLongitude(Double.valueOf(((JSONObject)json.get("coord")).get("lon").toString()));
        dbEntity.setDescription(((JSONObject)((JSONArray) json.get("weather")).get(0)).get("description").toString());
        dbEntity.setMainInfo(((JSONObject)((JSONArray) json.get("weather")).get(0)).get("main").toString());
        dbEntity.setIcon(((JSONObject)((JSONArray) json.get("weather")).get(0)).get("icon").toString());
        dbEntity.setTemperature(Double.valueOf(((JSONObject)json.get("main")).get("temp").toString()));
        dbEntity.setPressure(Double.valueOf(((JSONObject)json.get("main")).get("pressure").toString()));
        dbEntity.setHumidity(Double.valueOf(((JSONObject)json.get("main")).get("humidity").toString()));
        dbEntity.setMinimalTemperature(Double.valueOf(((JSONObject)json.get("main")).get("temp_min").toString()));
        dbEntity.setMaximumTemperature(Double.valueOf(((JSONObject)json.get("main")).get("temp_max").toString()));
        dbEntity.setVisibility(Double.valueOf(json.get("visibility").toString()));
        dbEntity.setWindSpeed(Double.valueOf(((JSONObject)json.get("wind")).get("speed").toString()));
        dbEntity.setWindDegree(Double.valueOf(((JSONObject)json.get("wind")).get("deg").toString()));
        dbEntity.setTime(Timestamp.from(Instant.ofEpochSecond(Long.valueOf(json.get("dt").toString()))));
        dbEntity.setSunrise(Timestamp.from(Instant.ofEpochSecond(Long.valueOf(((JSONObject)json.get("sys")).get("sunrise").toString()))));
        dbEntity.setSunset(Timestamp.from(Instant.ofEpochSecond(Long.valueOf(((JSONObject)json.get("sys")).get("sunset").toString()))));
        dbEntity.setCityName(json.get("name").toString().toLowerCase());
        return dbEntity;
    }

    private List<WeatherForecastDBEntity> writeWeatherForecastToDB(String cityName){
        List<WeatherForecastDBEntity> dbList = new ArrayList<>();
        JSONObject json = jsonConsumer.getJson(weatherUrlBuilder.buildForecastUrl(cityName));

        return dbList;
    }

}
