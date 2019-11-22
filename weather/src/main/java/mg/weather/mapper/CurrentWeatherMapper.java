package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.entity.CurrentWeather;
import mg.weather.dto.CurrentWeatherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public abstract class CurrentWeatherMapper {

    public static final CurrentWeatherMapper INSTANCE = Mappers.getMapper(CurrentWeatherMapper.class);

    public abstract CurrentWeather mapToEntity(CurrentWeatherDto dto);

    public abstract CurrentWeatherDto mapToDTO(CurrentWeather entity);
}
