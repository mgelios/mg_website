package mg.weather.services;

import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.weather.WeatherConfiguration;
import mg.weather.converters.CurrentWeatherEntityToDTO;
import mg.weather.converters.CurrentWeatherDTOToEntity;
import mg.weather.dbentities.CurrentWeatherDBEntity;
import mg.weather.models.CurrentWeather;
import mg.weather.repositories.CurrentWeatherRepository;
import mg.weather.utils.WeatherUrlBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ImprovedCurrentWeatherService {

    @Autowired
    WeatherConfiguration weatherConfiguration;
    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    WeatherUrlBuilder weatherUrlBuilder;
    @Autowired
    CurrentWeatherRepository currentWeatherRepository;
    @Autowired
    CurrentWeatherEntityToDTO currentWeatherEntityToDTO;
    @Autowired
    CurrentWeatherDTOToEntity currentWeatherDTOToEntity;

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
            updateCurrentWeatherByCityName(cityName);
            result = currentWeatherRepository.findByCityName(cityName).get();
        }
        return currentWeatherEntityToDTO.convert(result);
    }

    @Transactional
    public void updateDefaultCurrentWeather() {
        updateCurrentWeatherByCityName(weatherConfiguration.getDefaultCity());
    }

    public void updateCurrentWeatherByCityName(String cityName) {
        JSONObject currentWeatherJson = jsonConsumer.getJsonObject(weatherUrlBuilder.buildCurrentWeatherUrl(cityName));
        currentWeatherRepository.deleteAllByCityName(cityName);
        saveCurrentWeatherDBEntity(currentWeatherJson);
    }

    private void saveCurrentWeatherDBEntity(JSONObject json) {
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
        currentWeatherRepository.save(dbEntity);
    }
}
