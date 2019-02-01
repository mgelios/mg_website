package mg.weather.services;

import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.weather.WeatherConfiguration;
import mg.weather.converters.CurrentWeatherDBEntityToCurrentWeather;
import mg.weather.converters.CurrentWeatherToCurrentWeatherDBEntity;
import mg.weather.converters.WeatherForecastDBEntityToWeatherForecast;
import mg.weather.converters.WeatherForecastToWeatherForecastDBEntity;
import mg.weather.dbentities.CurrentWeatherDBEntity;
import mg.weather.dbentities.WeatherForecastDBEntity;
import mg.weather.models.CurrentWeather;
import mg.weather.models.WeatherForecast;
import mg.weather.repositories.CurrentWeatherRepository;
import mg.weather.repositories.WeatherForecastRepository;
import mg.weather.utils.WeatherUrlBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.sql.Time;
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
    CurrentWeatherDBEntityToCurrentWeather currentWeatherDBEntityToCurrentWeather;

    @Autowired
    CurrentWeatherToCurrentWeatherDBEntity currentWeatherToCurrentWeatherDBEntity;

    @Autowired
    WeatherForecastDBEntityToWeatherForecast weatherForecastDBEntityToWeatherForecast;

    @Autowired
    WeatherForecastToWeatherForecastDBEntity weatherForecastToWeatherForecastDBEntity;

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
        return currentWeatherDBEntityToCurrentWeather.convert(dbEntity);
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
                        .map(weatherForecastDBEntityToWeatherForecast::convert)
                        .collect(Collectors.toList());
            }
        } else {
            forecastRecords = writeWeatherForecastToDBEntity(cityName).stream()
                    .map(weatherForecastDBEntityToWeatherForecast::convert)
                    .collect(Collectors.toList());
        }
        return forecastRecords;
    }

    private CurrentWeatherDBEntity writeCurrentWeatherToDBEntity(String cityName){
        JSONObject json = jsonConsumer.getJson(weatherUrlBuilder.buildCurrentWeatherUrl(cityName));
        CurrentWeatherDBEntity dbEntity = new CurrentWeatherDBEntity();
        jsonHelper.getJSONObject(json,"coord.lat");
        dbEntity.setLatitude(json.getJSONObject("coord").getDouble("lat"));
        dbEntity.setLongitude(json.getJSONObject("coord").getDouble("lon"));
        dbEntity.setDescription(json.getJSONArray("weather").getJSONObject(0).getString("description"));
        dbEntity.setMainInfo(json.getJSONArray("weather").getJSONObject(0).getString("main"));
        dbEntity.setIcon(json.getJSONArray("weather").getJSONObject(0).getString("icon"));
        dbEntity.setTemperature(json.getJSONObject("main").getDouble("temp"));
        dbEntity.setPressure(json.getJSONObject("main").getDouble("pressure"));
        dbEntity.setHumidity(json.getJSONObject("main").getDouble("humidity"));
        dbEntity.setMinimalTemperature(json.getJSONObject("main").getDouble("temp_min"));
        dbEntity.setMaximumTemperature(json.getJSONObject("main").getDouble("temp_max"));
        dbEntity.setVisibility(json.getDouble("visibility"));
        dbEntity.setWindSpeed(json.getJSONObject("wind").getDouble("speed"));
        dbEntity.setWindDegree(json.getJSONObject("wind").getDouble("deg"));
        dbEntity.setTime(Timestamp.from(Instant.ofEpochSecond(json.getLong("dt"))));
        dbEntity.setSunrise(Timestamp.from(Instant.ofEpochSecond(json.getJSONObject("sys").getLong("sunrise"))));
        dbEntity.setSunset(Timestamp.from(Instant.ofEpochSecond(json.getJSONObject("sys").getLong("sunset"))));
        dbEntity.setCityName(json.get("name").toString().toLowerCase());
        return dbEntity;
    }

    private List<WeatherForecastDBEntity> writeWeatherForecastToDBEntity(String cityName){
        List<WeatherForecastDBEntity> dbList = new ArrayList<>();
        JSONObject json = jsonConsumer.getJson(weatherUrlBuilder.buildForecastUrl(cityName));
        JSONArray forecasts = json.getJSONArray("list");
        String city = json.getJSONObject("city").getString("name");
        int numberOfRecords = json.getInt("cnt");
        for (int i = 0; i < numberOfRecords; i++){
            WeatherForecastDBEntity dbEntity = new WeatherForecastDBEntity();
            JSONObject forecast = forecasts.getJSONObject(i);
            dbEntity.setTime(Timestamp.from(Instant.ofEpochSecond(forecast.getLong("dt"))));
            dbEntity.setTemperature(forecast.getJSONObject("main").getDouble("temp"));
            dbEntity.setMinimalTemperature(forecast.getJSONObject("main").getDouble("temp_min"));
            dbEntity.setMaximumTemperature(forecast.getJSONObject("main").getDouble("temp_max"));
            dbEntity.setPressure(forecast.getJSONObject("main").getDouble("pressure"));
            dbEntity.setSeaLevel(forecast.getJSONObject("main").getDouble("sea_level"));
            dbEntity.setGroundLevel(forecast.getJSONObject("main").getDouble("grnd_level"));
            dbEntity.setHumidity(forecast.getJSONObject("main").getDouble("humidity"));
            dbEntity.setMainInfo(forecast.getJSONArray("weather").getJSONObject(0).getString("main"));
            dbEntity.setDescription(forecast.getJSONArray("weather").getJSONObject(0).getString("description"));
            dbEntity.setIcon(forecast.getJSONArray("weather").getJSONObject(0).getString("icon"));
            dbEntity.setWindSpeed(forecast.getJSONObject("wind").getDouble("speed"));
            dbEntity.setWindDegree(forecast.getJSONObject("wind").getDouble("deg"));
            dbEntity.setCityName(city);
            dbEntity.setUpdateTime(Timestamp.from(Instant.now()));
            dbList.add(dbEntity);
        }
        return dbList;
    }

}
