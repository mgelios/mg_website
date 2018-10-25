package mg.weather.services;

import mg.utils.JSONConsumer;
import mg.weather.WeatherConfiguration;
import mg.weather.dbentities.CurrentWeatherDBEntity;
import mg.weather.models.CurrentWeather;
import mg.weather.repositories.CurrentWeatherRepository;
import mg.weather.utils.WeatherUrlBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BasicWeatherService implements WeatherService {

    @Autowired
    CurrentWeatherRepository currentWeatherRepository;

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Autowired
    WeatherUrlBuilder weatherUrlBuilder;

    @Autowired
    JSONConsumer jsonConsumer;


    @Override
    public CurrentWeather getDefaultWeatherInfo() {
        CurrentWeather weather = new CurrentWeather();
        CurrentWeatherDBEntity actualDBEntity = null;
//        if (currentWeatherRepository.findByCityName().isPresent()) {
//            actualDBEntity = currentWeatherRepository.findByCityName().get();
//            int dbCurrentWeatherHours = actualDBEntity.getTime().toLocalDateTime().getHour() / 2;
//            int currentTimeHours = LocalDateTime.now().getHour() / 2;
//            if (currentTimeHours != dbCurrentWeatherHours) {
//
//            }
//        } else {
//            JSONObject json = jsonConsumer.getJson(weatherUrlBuilder.buildCurrentDefaultWeatherUrl());
//        }
        weather.setCityName("Minsk");
        weather.setId(2L);
        weather.setHumidity(200);
        return weather;
    }

}
