package mg.weather.controller;

import mg.weather.dto.CurrentWeatherDto;
import mg.weather.dto.WeatherForecastDto;
import mg.weather.service.CurrentWeatherService;
import mg.weather.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/weather")
public class WeatherRestController {

    @Autowired
    WeatherForecastService weatherForecastService;
    @Autowired
    CurrentWeatherService currentWeatherService;

    @GetMapping("/current")
    CurrentWeatherDto getCurrentWeather() {
        return currentWeatherService.getDefaultCurrentWeather();
    }

    @GetMapping("/forecast/list")
    List<WeatherForecastDto> getWeatherForecast() {
        return weatherForecastService.getDefaultWeatherForecast();
    }
}
