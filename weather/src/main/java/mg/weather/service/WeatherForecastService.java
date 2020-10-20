package mg.weather.service;

import lombok.AllArgsConstructor;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.weather.WeatherConfiguration;
import mg.weather.entity.WeatherForecast;
import mg.weather.mapper.WeatherForecastMapper;
import mg.weather.dto.WeatherForecastDto;
import mg.weather.repository.WeatherForecastRepository;
import mg.weather.util.OpenWeatherUrlBuilder;
import mg.weather.util.WeatherUrlBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
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
@AllArgsConstructor
public class WeatherForecastService {

    private final JSONHelper jsonHelper;
    private final JSONConsumer jsonConsumer;
    private final OpenWeatherUrlBuilder weatherUrlBuilder;
    private final WeatherForecastRepository weatherForecastRepository;
    private final WeatherConfiguration weatherConfiguration;

    public List<WeatherForecastDto> getDefaultWeatherForecast() {
        return getWeatherForecastByCityName(weatherConfiguration.getDefaultCity());
    }

    public List<WeatherForecastDto> getWeatherForecastByCityName(String cityName) {
        List<WeatherForecast> weatherForecastList = new ArrayList<>();
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

    public List<WeatherForecast> updateWeatherForecastByCityName(String cityName) {
        JSONObject currentWeatherJson = jsonConsumer.getJsonObject(weatherUrlBuilder.buildForecastUrl(cityName));
        if (weatherForecastRepository.findAllByCityName(cityName).size() != 0) {
            weatherForecastRepository.deleteAllByCityName(cityName);
        }
        return saveWeatherForecasts(currentWeatherJson);
    }

    private List<WeatherForecast> saveWeatherForecasts(JSONObject json) {
        if (json != null) {
            List<WeatherForecast> result = new ArrayList<>();
            JSONArray forecasts = json.getJSONArray("list");
            String city = jsonHelper.getString(json, "city.name").toLowerCase();
            int numberOfRecords = json.getInt("cnt");
            for (int i = 0; i < numberOfRecords; i++) {
                JSONObject forecast = forecasts.getJSONObject(i);
                WeatherForecast dbEntity = WeatherForecast.builder()
                        .time(jsonHelper.getTimestampOfEpochSecond(forecast, "dt"))
                        .temperature(jsonHelper.getDouble(forecast, "main.temp"))
                        .minimalTemperature(jsonHelper.getDouble(forecast, "main.temp_min"))
                        .maximumTemperature(jsonHelper.getDouble(forecast, "main.temp_max"))
                        .pressure(jsonHelper.getDouble(forecast, "main.pressure"))
                        .seaLevel(jsonHelper.getDouble(forecast, "main.sea_level"))
                        .groundLevel(jsonHelper.getDouble(forecast, "main.grnd_level"))
                        .humidity(jsonHelper.getDouble(forecast, "main.humidity"))
                        .mainInfo(jsonHelper.getString(forecast, "weather[0].main"))
                        .description(jsonHelper.getString(forecast, "weather[0].description"))
                        .icon(jsonHelper.getString(forecast, "weather[0].icon"))
                        .windSpeed(jsonHelper.getDouble(forecast, "wind.speed"))
                        .windDegree(jsonHelper.getDouble(forecast, "wind.deg"))
                        .cityName(city)
                        .updateTime(Timestamp.from(Instant.now()))
                        .build();
                dbEntity = weatherForecastRepository.save(dbEntity);
                result.add(dbEntity);
            }
            return result;
        } else {
            return null;
        }
    }

}
