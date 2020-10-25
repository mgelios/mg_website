package mg.weather.util;

import lombok.AllArgsConstructor;
import mg.utils.url.UrlBuilder;
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

    public String buildCurrentWeatherUrl(String city) {
        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getWeatherPathPart())
                .addQueryParameter(weatherConfiguration.getPlaceParameter(), city)
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getUnitsParameter(), OPEN_WEATHER_METRIC_UNITS)
                .addQueryParameter(weatherConfiguration.getLangParameter(), OPEN_WEATHER_ENGLISH_LANGUAGE)
                .build().getUrl();
        return result;
    }

    public String buildForecastUrl(String city) {
        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getForecastPathPart())
                .addQueryParameter(weatherConfiguration.getPlaceParameter(), city)
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getUnitsParameter(), OPEN_WEATHER_METRIC_UNITS)
                .addQueryParameter(weatherConfiguration.getLangParameter(), OPEN_WEATHER_ENGLISH_LANGUAGE)
                .build().getUrl();
        return result;
    }

    public String buildUviUrl(String lat, String lon) {
        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getUviPathPart())
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getCoordLatParameter(), lat)
                .addQueryParameter(weatherConfiguration.getCoordLonParameter(), lon)
                .build().getUrl();
        return result;
    }
}
