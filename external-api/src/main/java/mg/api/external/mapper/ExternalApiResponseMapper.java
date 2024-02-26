package mg.api.external.mapper;

import mg.api.external.dto.ExternalApiResponseDto;
import mg.api.external.entity.ExternalApiResponse;
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
