package mg.weather.services;

import mg.utils.JSONConsumer;
import mg.weather.WeatherConfiguration;
import mg.weather.models.CurrentWeather;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicWeatherService implements WeatherService {

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Autowired
    JSONConsumer jsonConsumer;


    @Override
    public CurrentWeather getDefaultWeatherInfo() {
        CurrentWeather weather = new CurrentWeather();

        JSONObject json = jsonConsumer.getJson(buildCurrentDefaultWeatherUrl());
        return weather;
    }

    private String buildCurrentDefaultWeatherUrl(){
        StringBuilder builder = new StringBuilder();
        builder.append(weatherConfiguration.getBaseUrl())
                .append(weatherConfiguration.getWeatherSuffix())
                .append(weatherConfiguration.getFirstQueryDelimiter())
                .append("=")
                .append(weatherConfiguration.getDefaultCity())
                .append(weatherConfiguration.getQueryDelimiter())
                .append("appid=")
                .append(weatherConfiguration.getApiKey())
                .append(weatherConfiguration.getQueryDelimiter())
                .append("units=")
                .append(weatherConfiguration.getUnits())
                .append(weatherConfiguration.getQueryDelimiter())
                .append("lang=")
                .append(weatherConfiguration.getLang());
        return builder.toString();
    }


}
