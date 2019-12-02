package mg.weather.controller;

import mg.weather.service.CurrentWeatherService;
import mg.weather.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/weather")
public class WeatherRestController {

    @Autowired
    WeatherForecastService weatherForecastService;
    @Autowired
    CurrentWeatherService currentWeatherService;

    @GetMapping("/current")
    Object getCurrentWeather() {
        return currentWeatherService.getDefaultCurrentWeather();
    }

    @GetMapping("/forecast")
    Object getWeatherForecast() {
        return weatherForecastService.getDefaultWeatherForecast();
    }
}
