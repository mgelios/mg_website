package mg.weather;

import static org.junit.jupiter.api.Assertions.*;

import mg.weather.dto.openweather.WeatherDto;
import mg.weather.entity.Weather;
import mg.weather.mapper.WeatherMapper;
import mg.weather.mapper.WeatherMapperImpl;
import mg.weather.util.DtoUtils;
import mg.weather.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class BasicMapperTest {

    private final WeatherMapper weatherMapper = new WeatherMapperImpl();

    @Test
    public void testWeatherDtoToEntityMapper() {
        WeatherDto dto = DtoUtils.getDefaultWeatherDto();
        Weather entity = weatherMapper.mapToEntity(dto);
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getIcon(), entity.getIcon());
        assertEquals(dto.getMain(), entity.getMain());
    }

    @Test
    public void testWeatherEntityToDtoMapper() {
        Weather entity = EntityUtils.getDefaultWeatherEntity();
        WeatherDto dto = weatherMapper.mapToDTO(entity);
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getIcon(), dto.getIcon());
        assertEquals(entity.getMain(), dto.getMain());
    }
}
