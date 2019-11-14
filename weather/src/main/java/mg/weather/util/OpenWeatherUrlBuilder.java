package mg.weather.util;

import mg.weather.WeatherConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(WeatherConfiguration.class)
public class OpenWeatherUrlBuilder implements WeatherUrlBuilder {

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Override
    public String buildCurrentDefaultWeatherUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getWeatherSuffix())
                .append(weatherConfiguration.getFirstQueryDelimiter())
                .append(weatherConfiguration.getQuerySymbol())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getDefaultCity())
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());
        return builder.toString();
    }

    @Override
    public String buildCurrentWeatherUrl(String city) {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getWeatherSuffix())
                .append(weatherConfiguration.getFirstQueryDelimiter())
                .append(weatherConfiguration.getQuerySymbol())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(city)
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());
        return builder.toString();
    }

    @Override
    public String buildForecastDefaultUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getForecastSuffix())
                .append(weatherConfiguration.getFirstQueryDelimiter())
                .append(weatherConfiguration.getQuerySymbol())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getDefaultCity())
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());
        return builder.toString();
    }

    @Override
    public String buildForecastUrl(String city) {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getForecastSuffix())
                .append(weatherConfiguration.getFirstQueryDelimiter())
                .append(weatherConfiguration.getQuerySymbol())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(city)
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());
        return builder.toString();
    }

    @Override
    public String buildDefaultUviUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getUviSuffix())
                .append(weatherConfiguration.getFirstQueryDelimiter())
                .append(getApiKeyPart())
                .append(getDefaultCoordPart());
        return builder.toString();
    }


    private String getApiKeyPart() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getApiKeyVariable())
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
}
