package mg.weather.controllers;

import mg.weather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/current")
    Object getCurrentWeather(){
        //weatherService.getDefaultWeatherInfo();
        return weatherService.getDefaultWeatherInfo();
    }

}
