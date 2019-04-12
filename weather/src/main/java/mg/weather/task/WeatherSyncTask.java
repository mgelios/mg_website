package mg.weather.task;

import lombok.extern.slf4j.Slf4j;
import mg.weather.services.CurrentWeatherService;
import mg.weather.services.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class WeatherSyncTask {

    @Autowired
    CurrentWeatherService currentWeatherService;
    @Autowired
    WeatherForecastService weatherForecastService;

    @Scheduled(cron = "0 * * * * ?")
    public void syncWeatherInfo(){
        log.info("*** task running *** " + LocalDateTime.now().toString());
        currentWeatherService.updateDefaultCurrentWeather();
        weatherForecastService.updateDefaultWeatherForecast();
    }
}
