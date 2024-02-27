package mg.api.external.mapper;

import mg.api.external.entity.ApiConsumer;
import mg.api.external.dto.ApiConsumerCreationRequestDto;
import mg.api.external.dto.ApiConsumerResponseDto;
import mg.api.external.dto.ApiConsumerUpdateRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiConsumerMapper {

    ApiConsumerCreationRequestDto mapToCreationRequestDto(ApiConsumer entity);

    ApiConsumer mapToEntity(ApiConsumerCreationRequestDto dto);

    ApiConsumerUpdateRequestDto mapToUpdateRequestDto(ApiConsumer entity);

    ApiConsumer mapToEntity(ApiConsumerUpdateRequestDto dto);

    ApiConsumerResponseDto mapToResponseDto(ApiConsumer entity);

    ApiConsumer mapToEntity(ApiConsumerResponseDto dto);
}
