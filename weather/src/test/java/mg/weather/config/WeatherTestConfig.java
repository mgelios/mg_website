package mg.weather.config;

import mg.weather.mock.RepositoryMock;
import mg.weather.repository.OneCallRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class WeatherTestConfig {

    @Bean
    public OneCallRepository currentWeatherRepository() {
        return RepositoryMock.getOneCallRepository();
    }

}
