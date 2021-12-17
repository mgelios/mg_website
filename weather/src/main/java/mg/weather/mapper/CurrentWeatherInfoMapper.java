package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.CurrentWeatherInfoDto;
import mg.weather.entity.CurrentWeatherInfo;
import org.mapstruct.Mapper;

@Mapper(
        uses = {
                DateMapper.class,
                WeatherMapper.class
        },
        componentModel = "spring"
)
public interface CurrentWeatherInfoMapper {

    CurrentWeatherInfoDto mapToDTO(CurrentWeatherInfo entity);

    CurrentWeatherInfo mapToEntity(CurrentWeatherInfoDto dto);
}
