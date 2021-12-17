package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.DailyWeatherForecastInfoDto;
import mg.weather.entity.DailyWeatherForecastInfo;
import org.mapstruct.Mapper;

@Mapper(
        uses = {
                DateMapper.class,
                TemperatureInfoMapper.class,
                TemperatureFeelsLikeMapper.class,
                WeatherMapper.class
        },
        componentModel = "spring"
)
public interface DailyWeatherForecastMapper {

    DailyWeatherForecastInfoDto mapToDTO(DailyWeatherForecastInfo entity);

    DailyWeatherForecastInfo mapToEntity(DailyWeatherForecastInfoDto dto);
}
