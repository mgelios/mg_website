package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.OneCallDto;
import mg.weather.entity.OneCall;
import org.mapstruct.Mapper;

@Mapper(
        uses = {
                DateMapper.class,
                DailyWeatherForecastMapper.class,
                CurrentWeatherInfoMapper.class,
                GeocodingInfoMapper.class
        },
        componentModel = "spring"
)
public interface OneCallMapper {

    OneCall mapToEntity (OneCallDto dto);

    OneCallDto mapToDTO(OneCall entity);
}
