package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dbentity.WeatherForecastDBEntity;
import mg.weather.model.WeatherForecast;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses=DateMapper.class)
public abstract class WeatherForecastMapper {

    public static final WeatherForecastMapper INSTANCE = Mappers.getMapper(WeatherForecastMapper.class);

    public abstract WeatherForecast mapToDTO(WeatherForecastDBEntity dbEntity);

    public abstract WeatherForecastDBEntity mapToEntity(WeatherForecast dto);
}
