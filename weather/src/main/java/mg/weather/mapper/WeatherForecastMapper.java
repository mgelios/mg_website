package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.entity.WeatherForecast;
import mg.weather.dto.WeatherForecastDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public abstract class WeatherForecastMapper {

    public static final WeatherForecastMapper INSTANCE = Mappers.getMapper(WeatherForecastMapper.class);

    public abstract WeatherForecastDto mapToDTO(WeatherForecast dbEntity);

    public abstract WeatherForecast mapToEntity(WeatherForecastDto dto);
}
