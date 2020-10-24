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
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getWeatherSuffix())
                .append(weatherConfiguration.getQuerySymbol())
                .append(weatherConfiguration.getWeatherQuerySuffix())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(city)
                .append(weatherConfiguration.getQueryDelimiter())
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());

        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(weatherConfiguration.getHost())
                .addPathPart(weatherConfiguration.getWeatherPathPart())
                .addQueryParameter()
                .build().getUrl();
        return result;
    }

    public String buildForecastDefaultUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getForecastSuffix())
                .append(weatherConfiguration.getQuerySymbol())
                .append(weatherConfiguration.getWeatherQuerySuffix())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getDefaultCity())
                .append(weatherConfiguration.getQueryDelimiter())
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());
        return builder.toString();
    }

    public String buildForecastUrl(String city) {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getForecastSuffix())
                .append(weatherConfiguration.getQuerySymbol())
                .append(weatherConfiguration.getWeatherQuerySuffix())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(city)
                .append(weatherConfiguration.getQueryDelimiter())
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());
        return builder.toString();
    }

    public String buildDefaultUviUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getUviSuffix())
                .append(weatherConfiguration.getQuerySymbol())
                .append(getApiKeyPart())
                .append(getDefaultCoordPart());
        return builder.toString();
    }

    public String buildUviUrl(String lat, String lon) {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getUviSuffix())
                .append(weatherConfiguration.getQuerySymbol())
                .append(getApiKeyPart())
                .append(getCoordPart(lat, lon));
        return builder.toString();
    }


    private String getApiKeyPart() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getApiKeyVariable())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getApiKey());
        return builder.toString();
    }

    private String getUnitsPart() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getUnitsVariable())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getUnits());
        return builder.toString();
    }

    private String getLangPart() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getLangVariable())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getLang());
        return builder.toString();
    }

    private String getDefaultCoordPart() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getCoordLatSuffix())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getDefaultCoordLat())
                .append(weatherConfiguration.getCoordLonSuffix())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getDefaultCoordLon());
        return builder.toString();
    }

    private String getCoordPart(String lat, String lon) {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getCoordLatSuffix())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(lat)
                .append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getCoordLonSuffix())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(lon);
        return builder.toString();
    }
}
