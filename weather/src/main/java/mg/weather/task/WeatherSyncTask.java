package mg.weather.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class WeatherSyncTask {

    @Scheduled(cron = "0/30 * * * * ?")
    public void syncWeatherInfo(){
        log.info("*** task running *** " + LocalDateTime.now().toString());
    }
}
