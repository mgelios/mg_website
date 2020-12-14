package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.entity.WeatherForecast;
import mg.weather.dto.WeatherForecastDto;
import org.mapstruct.Mapper;

@Mapper(uses=DateMapper.class, componentModel = "spring")
public interface WeatherForecastMapper {

    WeatherForecastDto mapToDTO(WeatherForecast dbEntity);

    WeatherForecast mapToEntity(WeatherForecastDto dto);
}
