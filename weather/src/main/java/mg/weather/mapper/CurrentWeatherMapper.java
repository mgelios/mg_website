package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dbentity.CurrentWeatherDBEntity;
import mg.weather.model.CurrentWeather;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public abstract class CurrentWeatherMapper {

    public static final CurrentWeatherMapper INSTANCE = Mappers.getMapper(CurrentWeatherMapper.class);

    public abstract CurrentWeatherDBEntity mapToEntity(CurrentWeather dto);

    public abstract CurrentWeather mapToDTO(CurrentWeatherDBEntity entity);
}
