package mg.weather.mapper;

import mg.utils.mapper.DateMapper;
import mg.weather.dto.openweather.GeocodingInfoDto;
import mg.weather.entity.GeocodingInfo;
import org.mapstruct.Mapper;

@Mapper(uses= DateMapper.class, componentModel = "spring")
public interface GeocodingInfoMapper {

    GeocodingInfo mapToEntity(GeocodingInfoDto dto);

    GeocodingInfoDto mapToDTO(GeocodingInfo entity);
}
