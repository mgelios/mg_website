package mg.weather;

import static org.junit.jupiter.api.Assertions.*;

import mg.weather.mock.RepositoryMock;
import mg.weather.repository.OneCallRepository;
import org.junit.jupiter.api.Test;

public class BasicRepositoryTest {

    private final OneCallRepository oneCallRepository = RepositoryMock.getOneCallRepository();

    @Test
    public void testGetAllItems() {
//        assertNotNull(currentWeatherRepository.findAll());
//        assertTrue(currentWeatherRepository.findAll().iterator().hasNext());
//        assertEquals("defaultCity", currentWeatherRepository.findAll().iterator().next().getCityName());

        assertNotNull(oneCallRepository.findAll());
    }
}
