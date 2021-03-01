package mg.weather.controller;

import lombok.AllArgsConstructor;
import mg.weather.dto.CurrentWeatherDto;
import mg.weather.service.CurrentWeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/weather/current")
@AllArgsConstructor
public class CurrentWeatherRestController {

    private final CurrentWeatherService currentWeatherService;

    @GetMapping
    CurrentWeatherDto getCurrentWeather() {
        return currentWeatherService.getDefaultCurrentWeather();
    }
}
