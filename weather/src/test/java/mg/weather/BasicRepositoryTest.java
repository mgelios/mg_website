package mg.weather;

import static org.junit.jupiter.api.Assertions.*;

import mg.weather.mock.RepositoryMock;
import mg.weather.repository.CurrentWeatherRepository;
import org.junit.jupiter.api.Test;

public class BasicRepositoryTest {

    private final CurrentWeatherRepository currentWeatherRepository = RepositoryMock.getCurrentWeatherRepository();

    @Test
    public void testGetAllItems() {
        assertNotNull(currentWeatherRepository.findAll());
        assertTrue(currentWeatherRepository.findAll().iterator().hasNext());
        assertEquals("defaultCity", currentWeatherRepository.findAll().iterator().next().getCityName());
    }
}
