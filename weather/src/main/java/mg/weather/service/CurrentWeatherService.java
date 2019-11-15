package mg.weather.service;

import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.weather.WeatherConfiguration;
import mg.weather.dbentity.CurrentWeatherDBEntity;
import mg.weather.mapper.CurrentWeatherMapper;
import mg.weather.model.CurrentWeather;
import mg.weather.repository.CurrentWeatherRepository;
import mg.weather.util.WeatherUrlBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class CurrentWeatherService {

    @Autowired
    private WeatherConfiguration weatherConfiguration;
    @Autowired
    private JSONConsumer jsonConsumer;
    @Autowired
    private JSONHelper jsonHelper;
    @Autowired
    private WeatherUrlBuilder weatherUrlBuilder;
    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    public CurrentWeather getDefaultCurrentWeather() {
        return getCurrentWeatherByCityName(weatherConfiguration.getDefaultCity());
    }

    public CurrentWeather getCurrentWeatherByCityName(String cityName) {
        Optional<CurrentWeatherDBEntity> optionalCurrentWeather = currentWeatherRepository.findByCityName(cityName);
        CurrentWeatherDBEntity result = null;
        if (optionalCurrentWeather.isPresent()) {
            result = optionalCurrentWeather.get();
        }
        if (result == null || result.getTime().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
            result = updateCurrentWeatherByCityName(cityName);
        }
        return CurrentWeatherMapper.INSTANCE.mapToDTO(result);
    }

    public void updateDefaultCurrentWeather() {
        updateCurrentWeatherByCityName(weatherConfiguration.getDefaultCity());
    }

    public CurrentWeatherDBEntity updateCurrentWeatherByCityName(String cityName) {
        JSONObject currentWeatherJson = jsonConsumer.getJsonObject(weatherUrlBuilder.buildCurrentWeatherUrl(cityName));
        if (currentWeatherRepository.findAllByCityName(cityName).size() != 0) {
            currentWeatherRepository.deleteAllByCityName(cityName);
        }
        return saveCurrentWeatherDBEntity(currentWeatherJson);
    }

    private CurrentWeatherDBEntity saveCurrentWeatherDBEntity(JSONObject json) {
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
        dbEntity.setUvi(getUvi(dbEntity.getLatitude(), dbEntity.getLongitude()));
        return currentWeatherRepository.save(dbEntity);
    }

    private double getUvi(double lat, double lon) {
        double uvi = 0.0;
        JSONObject currentUviJson = jsonConsumer.getJsonObject(weatherUrlBuilder.buildUviUrl(String.valueOf(lat), String.valueOf(lon)));
        uvi = jsonHelper.getDouble(currentUviJson, "value");
        return uvi;
    }
}
