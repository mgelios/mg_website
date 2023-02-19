package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.CurrentWeatherDto;
import mg.weather.entity.CurrentWeather;
import org.mapstruct.Mapper;

@Mapper(
        uses = {
                DateMapper.class,
                WeatherMapper.class
        },
        componentModel = "spring"
)
public interface CurrentWeatherMapper {

    CurrentWeatherDto mapToDTO(CurrentWeather entity);

    CurrentWeather mapToEntity(CurrentWeatherDto dto);
}
