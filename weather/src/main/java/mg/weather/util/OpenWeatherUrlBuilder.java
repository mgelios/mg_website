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
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getWeatherDataPathPart())
                .addPathPart(weatherConfiguration.getWeatherPathPart())
                .addQueryParameter(weatherConfiguration.getPlaceParameter(), city)
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getUnitsParameter(), OPEN_WEATHER_METRIC_UNITS)
                .addQueryParameter(weatherConfiguration.getLangParameter(), OPEN_WEATHER_ENGLISH_LANGUAGE)
                .build().getUrl();
    }

    public String buildForecastUrl(String city) {
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getWeatherDataPathPart())
                .addPathPart(weatherConfiguration.getForecastPathPart())
                .addQueryParameter(weatherConfiguration.getPlaceParameter(), city)
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getUnitsParameter(), OPEN_WEATHER_METRIC_UNITS)
                .addQueryParameter(weatherConfiguration.getLangParameter(), OPEN_WEATHER_ENGLISH_LANGUAGE)
                .build().getUrl();
    }

    public String buildUviUrl(String lat, String lon) {
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getWeatherDataPathPart())
                .addPathPart(weatherConfiguration.getUviPathPart())
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getCoordLatParameter(), lat)
                .addQueryParameter(weatherConfiguration.getCoordLonParameter(), lon)
                .build().getUrl();
    }

    public String buildOneCallUrl(String lat, String lon) {
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getWeatherDataPathPart())
                .addPathPart(weatherConfiguration.getOneCallPathPart())
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getCoordLatParameter(), lat)
                .addQueryParameter(weatherConfiguration.getCoordLonParameter(), lon)
                .addQueryParameter(weatherConfiguration.getUnitsParameter(), OPEN_WEATHER_METRIC_UNITS)
                .build().getUrl();
    }

    public String buildGeocodingUrl(String cityName, long limit) {
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getGeoDataPathPart())
                .addQueryParameter(weatherConfiguration.getPlaceParameter(), cityName)
                .addQueryParameter(weatherConfiguration.getApiKeyParameter(), weatherConfiguration.getApiKey())
                .addQueryParameter(weatherConfiguration.getLimitParameter(), String.valueOf(limit))
                .build().getUrl();
    }
}
