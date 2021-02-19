package mg.utils.api.consumer;

import mg.utils.api.consumer.dto.ApiConsumerCreationRequestDto;
import mg.utils.api.consumer.dto.ApiConsumerResponseDto;
import mg.utils.api.consumer.dto.ApiConsumerUpdateRequestDto;
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
