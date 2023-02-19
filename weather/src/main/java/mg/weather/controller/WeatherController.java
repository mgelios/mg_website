package mg.weather.controller;

import lombok.AllArgsConstructor;
import mg.weather.dto.openweather.OneCallDto;
import mg.weather.service.CurrentWeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/weather")
@AllArgsConstructor
public class WeatherController {

    private final CurrentWeatherService currentWeatherService;

    @GetMapping
    OneCallDto getOneCallWeather() {
        return null;
    }

    @GetMapping("/current")
    CurrentWeatherDto getCurrentWeather() {
        return currentWeatherService.getDefaultCurrentWeather();
    }

    @GetMapping("/forecast")
    OneCallDto getWeatherForecast() {
        return null;
    }
}
