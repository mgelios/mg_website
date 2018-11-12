package mg.weather.controllers;

import mg.weather.models.CurrentWeather;
import mg.weather.models.WeatherForecast;
import mg.weather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/current")
    ModelAndView getCurrentWeather(){
        CurrentWeather currentWeather = weatherService.getDefaultWeatherInfo();
        List<WeatherForecast> weatherForecasts = weatherService.getDefaultWeatherForecast();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("weather", currentWeather);
        modelAndView.addObject("forecasts", weatherForecasts);
        modelAndView.setViewName("weather");
        return modelAndView;
    }

}
