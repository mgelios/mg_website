package mg.api.external.cache.mapper;

import mg.api.external.cache.dto.ExternalApiResponseDto;
import mg.api.external.cache.entity.ExternalApiResponse;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;

@Mapper(
        uses = {
                DateMapper.class,
        },
        componentModel = "spring"
)
public interface ExternalApiResponseMapper {

    ExternalApiResponse mapToEntity(ExternalApiResponseDto dto);

    ExternalApiResponseDto mapToDto(ExternalApiResponse entity);
}
