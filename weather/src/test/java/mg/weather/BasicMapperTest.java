package mg.weather;

import static org.junit.jupiter.api.Assertions.*;

import mg.weather.dto.openweather.WeatherDto;
import mg.weather.entity.Weather;
import mg.weather.mapper.WeatherMapper;
import mg.weather.mapper.WeatherMapperImpl;
import org.junit.jupiter.api.Test;

public class BasicMapperTest {

    private final WeatherMapper weatherMapper = new WeatherMapperImpl();

    @Test
    public void testWeatherDtoToEntityMapper() {
        WeatherDto dto = new WeatherDto();
        dto.setDescription("someDescription");
        dto.setIcon("someIcon");
        dto.setMain("someMainInfo");
        Weather entity = weatherMapper.mapToEntity(dto);
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getIcon(), entity.getIcon());
        assertEquals(dto.getMain(), entity.getMain());
    }

    @Test
    public void testWeatherEntityToDtoMapper() {
        Weather entity = new Weather();
        entity.setDescription("someDescription");
        entity.setIcon("someIcon");
        entity.setMain("someMainInfo");
        WeatherDto dto = weatherMapper.mapToDTO(entity);
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getIcon(), dto.getIcon());
        assertEquals(entity.getMain(), dto.getMain());
    }
}
