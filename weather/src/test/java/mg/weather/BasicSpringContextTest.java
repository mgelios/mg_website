package mg.weather;

import static org.junit.jupiter.api.Assertions.*;

import mg.weather.config.WeatherTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = WeatherTestConfig.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "/classpath:weather-test-config.properties")
public class BasicSpringContextTest {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    @Test
    public void testRepositoryBean() {
        assertNotNull(currentWeatherRepository.findAll());
        assertTrue(currentWeatherRepository.findAll().iterator().hasNext());
        assertEquals("defaultCity", currentWeatherRepository.findAll().iterator().next().getCityName());
    }
}
