package mg.weather.controller;

import lombok.AllArgsConstructor;
import mg.weather.dto.WeatherForecastDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/weather/forecast")
@AllArgsConstructor
public class WeatherForecastRestController {

    private final WeatherForecastService weatherForecastService;

    @GetMapping("/list")
    List<WeatherForecastDto> getWeatherForecast() {
        return weatherForecastService.getDefaultWeatherForecast();
    }
}
