package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.TemperatureFeelsLikeInfoDto;
import mg.weather.entity.TemperatureFeelsLikeInfo;
import org.mapstruct.Mapper;

@Mapper(uses= DateMapper.class, componentModel = "spring")
public interface TemperatureFeelsLikeMapper {

    TemperatureFeelsLikeInfoDto mapToDTO(TemperatureFeelsLikeInfo entity);

    TemperatureFeelsLikeInfo mapToEntity(TemperatureFeelsLikeInfoDto dto);
}
