package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.TemperatureInfoDto;
import mg.weather.entity.TemperatureInfo;
import org.mapstruct.Mapper;

@Mapper(uses= DateMapper.class, componentModel = "spring")
public interface TemperatureInfoMapper {

    TemperatureInfo mapToEntity(TemperatureInfoDto dto);

    TemperatureInfoDto mapToDTO(TemperatureInfo entity);
}
