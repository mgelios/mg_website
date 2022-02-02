package mg.weather;

import static org.junit.jupiter.api.Assertions.*;

import mg.weather.dto.CurrentWeatherDto;
import org.junit.jupiter.api.Test;

public class TestTest {

    @Test
    public void someTestTest() {
        CurrentWeatherDto dto = new CurrentWeatherDto();
        dto.setDescription("someDescription");
        assertEquals("someDescription", dto.getDescription());
    }
}
