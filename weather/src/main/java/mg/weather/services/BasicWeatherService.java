package mg.weather.services;

import mg.utils.JSONConsumer;
import mg.weather.WeatherConfiguration;
import mg.weather.models.CurrentWeather;
import mg.weather.utils.WeatherUrlBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicWeatherService implements WeatherService {

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Autowired
    WeatherUrlBuilder weatherUrlBuilder;

    @Autowired
    JSONConsumer jsonConsumer;


    @Override
    public CurrentWeather getDefaultWeatherInfo() {
        CurrentWeather weather = new CurrentWeather();
        JSONObject json = jsonConsumer.getJson(weatherUrlBuilder.buildCurrentDefaultWeatherUrl());
        return weather;
    }


}
