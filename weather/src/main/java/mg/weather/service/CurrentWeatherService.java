package mg.weather.service;

import lombok.AllArgsConstructor;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.utils.api.consumer.ApiConsumerAuthType;
import mg.utils.api.consumer.ApiConsumerService;
import mg.weather.WeatherConfiguration;
import mg.weather.entity.CurrentWeather;
import mg.weather.mapper.CurrentWeatherMapper;
import mg.weather.dto.CurrentWeatherDto;
import mg.weather.repository.CurrentWeatherRepository;
import mg.weather.util.OpenWeatherUrlBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CurrentWeatherService {

    private final WeatherConfiguration weatherConfiguration;
    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final OpenWeatherUrlBuilder weatherUrlBuilder;
    private final CurrentWeatherRepository currentWeatherRepository;
    private final CurrentWeatherMapper currentWeatherMapper;
    private final ApiConsumerService apiConsumerService;

    public CurrentWeatherDto getDefaultCurrentWeather() {
        return getCurrentWeatherByCityName(weatherConfiguration.getDefaultCity());
    }

    public CurrentWeatherDto getCurrentWeatherByCityName(String cityName) {
        Optional<CurrentWeather> optionalCurrentWeather = currentWeatherRepository.findByCityName(cityName);
        CurrentWeather result = null;
        if (optionalCurrentWeather.isPresent()) {
            result = optionalCurrentWeather.get();
        }
        if (result == null || result.getTime().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
            result = updateCurrentWeatherByCityName(cityName);
        }
        return currentWeatherMapper.mapToDTO(result);
    }

    public void updateDefaultCurrentWeather() {
        updateCurrentWeatherByCityName(weatherConfiguration.getDefaultCity());
    }

    public CurrentWeather updateCurrentWeatherByCityName(String cityName) {
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildCurrentWeatherUrl(cityName),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        JSONObject currentWeatherJson = jsonConsumer.getJsonObject(url);
        if (currentWeatherRepository.findAllByCityName(cityName).size() != 0) {
            currentWeatherRepository.deleteAllByCityName(cityName);
        }
        return saveCurrentWeather(currentWeatherJson);
    }

    private CurrentWeather saveCurrentWeather(JSONObject json) {
        if (json != null) {
            CurrentWeather dbEntity = CurrentWeather.builder()
                    .latitude(jsonHelper.getDouble(json, "coord.lat"))
                    .longitude(jsonHelper.getDouble(json, "coord.lon"))
                    .description(jsonHelper.getString(json, "weather[0].description"))
                    .mainInfo(jsonHelper.getString(json, "weather[0].main"))
                    .icon(jsonHelper.getString(json, "weather[0].icon"))
                    .temperature(jsonHelper.getDouble(json, "main.temp"))
                    .pressure(jsonHelper.getDouble(json, "main.pressure"))
                    .humidity(jsonHelper.getDouble(json, "main.humidity"))
                    .minimalTemperature(jsonHelper.getDouble(json, "main.temp_min"))
                    .maximumTemperature(jsonHelper.getDouble(json, "main.temp_max"))
                    .visibility(jsonHelper.getDouble(json, "visibility"))
                    .windSpeed(jsonHelper.getDouble(json, "wind.speed"))
                    .windDegree(jsonHelper.getDouble(json, "wind.deg"))
                    .time(jsonHelper.getOffsetDateTimeOfEpochSecond(json, "dt"))
                    .sunrise(jsonHelper.getOffsetDateTimeOfEpochSecond(json, "sys.sunrise"))
                    .sunset(jsonHelper.getOffsetDateTimeOfEpochSecond(json, "sys.sunset"))
                    .cityName(jsonHelper.getString(json, "name").toLowerCase())
                    .build();
            dbEntity.setUvi(getUvi(dbEntity.getLatitude(), dbEntity.getLongitude()));
            return currentWeatherRepository.save(dbEntity);
        } else {
            return null;
        }
    }

    private double getUvi(double lat, double lon) {
        double uvi = 0.0;
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildUviUrl(String.valueOf(lat), String.valueOf(lon)),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        JSONObject currentUviJson = jsonConsumer.getJsonObject(url);
        uvi = currentUviJson != null ? jsonHelper.getDouble(currentUviJson, "value") : 0.0;
        return uvi;
    }
}
