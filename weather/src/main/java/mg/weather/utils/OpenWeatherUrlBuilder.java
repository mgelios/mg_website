package mg.weather.utils;

import mg.weather.WeatherConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherUrlBuilder implements WeatherUrlBuilder {

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Override
    public String buildCurrentDefaultWeatherUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getWeatherSuffix())
                .append(weatherConfiguration.getFirstQueryDelimiter())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getDefaultCity())
                .append(getApiKeyPart())
                .append(getUnitsPart())
                .append(getLangPart());
        return builder.toString();
    }

    private String getApiKeyPart(){
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getApiKeyVariable())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getApiKey());
        return builder.toString();
    }

    private String getUnitsPart(){
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getUnitsVariable())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getUnits());
        return builder.toString();
    }

    private String getLangPart(){
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getQueryDelimiter())
                .append(weatherConfiguration.getLangVariable())
                .append(weatherConfiguration.getEqualitySymbol())
                .append(weatherConfiguration.getLang());
        return builder.toString();

    }

}
