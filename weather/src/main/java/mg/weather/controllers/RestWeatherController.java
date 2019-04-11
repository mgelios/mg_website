package mg.weather.controllers;

import mg.weather.services.ImprovedCurrentWeatherService;
import mg.weather.services.ImprovedWeatherForecastService;
import mg.weather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/weather")
public class RestWeatherController {

    @Autowired
    WeatherService weatherService;
    @Autowired
    ImprovedWeatherForecastService improvedWeatherForecastService;
    @Autowired
    ImprovedCurrentWeatherService improvedCurrentWeatherService;

    @RequestMapping("/current")
    Object getCurrentWeather() {
        return improvedCurrentWeatherService.getDefaultCurrentWeather();
    }

    @RequestMapping("/forecast")
    Object getWeatherForecast() {
        return improvedWeatherForecastService.getDefaultWeatherForecast();
    }
}
