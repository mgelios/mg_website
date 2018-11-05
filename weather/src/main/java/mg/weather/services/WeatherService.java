package mg.weather.services;

import mg.weather.models.CurrentWeather;
import mg.weather.models.WeatherForecast;

import java.util.List;

public interface WeatherService {

    CurrentWeather getDefaultWeatherInfo();

    List<WeatherForecast> getDefaultWeatherForecast();

}
