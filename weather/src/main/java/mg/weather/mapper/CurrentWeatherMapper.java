package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.entity.CurrentWeather;
import mg.weather.dto.CurrentWeatherDto;
import org.mapstruct.Mapper;

@Mapper(uses=DateMapper.class, componentModel = "spring")
public interface CurrentWeatherMapper {

    CurrentWeather mapToEntity(CurrentWeatherDto dto);

    CurrentWeatherDto mapToDTO(CurrentWeather entity);
}
