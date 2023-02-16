package mg.weather.util;

import lombok.AllArgsConstructor;
import mg.weather.WeatherConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(WeatherConfiguration.class)
@AllArgsConstructor
public class OpenWeatherUrlBuilder{

    private final WeatherConfiguration weatherConfiguration;

    public static final String OPEN_WEATHER_IMPERIAL_UNITS = "imperial";
    public static final String OPEN_WEATHER_METRIC_UNITS = "metric";
    public static final String OPEN_WEATHER_STANDARD_UNITS = "standard";

    public static final String OPEN_WEATHER_RUSSIAN_LANGUAGE = "ru";
    public static final String OPEN_WEATHER_ENGLISH_LANGUAGE = "en";

    public String buildOneCallUrl(double lat, double lon) {
        return String.format(weatherConfiguration.getOneCallUrl(), lat, lon, "%s", OPEN_WEATHER_METRIC_UNITS);
    }

    public String buildGeocodingUrl(String cityName, long limit) {
        return String.format(weatherConfiguration.getGeocodingUrl(), cityName, limit, "%s");
    }
}
