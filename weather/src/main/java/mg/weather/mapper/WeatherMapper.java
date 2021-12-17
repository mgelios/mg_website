package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.WeatherDto;
import mg.weather.entity.Weather;
import org.mapstruct.Mapper;

@Mapper(uses= DateMapper.class, componentModel = "spring")
public interface WeatherMapper {

    Weather mapToEntity(WeatherDto dto);

    WeatherDto mapToDTO(Weather entity);
}
