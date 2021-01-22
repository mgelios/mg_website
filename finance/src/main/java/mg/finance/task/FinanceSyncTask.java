package mg.finance.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class FinanceSyncTask {

//    @Scheduled(cron = "0 * * * * ?")
    public void syncWeatherInfo(){
        log.info("*** finance task running *** " + LocalDateTime.now().toString());
    }
}
