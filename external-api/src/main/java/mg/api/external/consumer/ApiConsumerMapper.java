package mg.api.external.consumer;

import mg.api.external.consumer.dto.ApiConsumerCreationRequestDto;
import mg.api.external.consumer.dto.ApiConsumerResponseDto;
import mg.api.external.consumer.dto.ApiConsumerUpdateRequestDto;
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
