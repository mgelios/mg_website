package mg.weather.controllers;

import mg.weather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/current")
    String getCurrentWeather(){
        weatherService.getDefaultWeatherInfo();
        return "";
    }

}
