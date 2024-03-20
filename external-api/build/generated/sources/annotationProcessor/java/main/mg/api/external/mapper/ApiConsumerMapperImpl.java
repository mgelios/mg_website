package mg.api.external.mapper;

import javax.annotation.processing.Generated;
import mg.api.external.dto.ApiConsumerCreationRequestDto;
import mg.api.external.dto.ApiConsumerResponseDto;
import mg.api.external.dto.ApiConsumerUpdateRequestDto;
import mg.api.external.entity.ApiConsumer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T18:23:21+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.2 (N/A)"
)
@Component
public class ApiConsumerMapperImpl implements ApiConsumerMapper {

    @Override
    public ApiConsumerCreationRequestDto mapToCreationRequestDto(ApiConsumer entity) {
        if ( entity == null ) {
            return null;
        }

        ApiConsumerCreationRequestDto apiConsumerCreationRequestDto = new ApiConsumerCreationRequestDto();

        apiConsumerCreationRequestDto.setName( entity.getName() );
        apiConsumerCreationRequestDto.setApiKey( entity.getApiKey() );
        apiConsumerCreationRequestDto.setToken( entity.getToken() );
        apiConsumerCreationRequestDto.setClientId( entity.getClientId() );
        apiConsumerCreationRequestDto.setClientSecret( entity.getClientSecret() );

        return apiConsumerCreationRequestDto;
    }

    @Override
    public ApiConsumer mapToEntity(ApiConsumerCreationRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ApiConsumer apiConsumer = new ApiConsumer();

        apiConsumer.setName( dto.getName() );
        apiConsumer.setApiKey( dto.getApiKey() );
        apiConsumer.setToken( dto.getToken() );
        apiConsumer.setClientId( dto.getClientId() );
        apiConsumer.setClientSecret( dto.getClientSecret() );

        return apiConsumer;
    }

    @Override
    public ApiConsumerUpdateRequestDto mapToUpdateRequestDto(ApiConsumer entity) {
        if ( entity == null ) {
            return null;
        }

        ApiConsumerUpdateRequestDto apiConsumerUpdateRequestDto = new ApiConsumerUpdateRequestDto();

        apiConsumerUpdateRequestDto.setUuid( entity.getUuid() );
        apiConsumerUpdateRequestDto.setName( entity.getName() );
        apiConsumerUpdateRequestDto.setApiKey( entity.getApiKey() );
        apiConsumerUpdateRequestDto.setToken( entity.getToken() );
        apiConsumerUpdateRequestDto.setClientId( entity.getClientId() );
        apiConsumerUpdateRequestDto.setClientSecret( entity.getClientSecret() );

        return apiConsumerUpdateRequestDto;
    }

    @Override
    public ApiConsumer mapToEntity(ApiConsumerUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ApiConsumer apiConsumer = new ApiConsumer();

        apiConsumer.setUuid( dto.getUuid() );
        apiConsumer.setName( dto.getName() );
        apiConsumer.setApiKey( dto.getApiKey() );
        apiConsumer.setToken( dto.getToken() );
        apiConsumer.setClientId( dto.getClientId() );
        apiConsumer.setClientSecret( dto.getClientSecret() );

        return apiConsumer;
    }

    @Override
    public ApiConsumerResponseDto mapToResponseDto(ApiConsumer entity) {
        if ( entity == null ) {
            return null;
        }

        ApiConsumerResponseDto apiConsumerResponseDto = new ApiConsumerResponseDto();

        apiConsumerResponseDto.setUuid( entity.getUuid() );
        apiConsumerResponseDto.setName( entity.getName() );
        apiConsumerResponseDto.setApiKey( entity.getApiKey() );
        apiConsumerResponseDto.setToken( entity.getToken() );
        apiConsumerResponseDto.setClientId( entity.getClientId() );
        apiConsumerResponseDto.setClientSecret( entity.getClientSecret() );

        return apiConsumerResponseDto;
    }

    @Override
    public ApiConsumer mapToEntity(ApiConsumerResponseDto dto) {
        if ( dto == null ) {
            return null;
        }

        ApiConsumer apiConsumer = new ApiConsumer();

        apiConsumer.setUuid( dto.getUuid() );
        apiConsumer.setName( dto.getName() );
        apiConsumer.setApiKey( dto.getApiKey() );
        apiConsumer.setToken( dto.getToken() );
        apiConsumer.setClientId( dto.getClientId() );
        apiConsumer.setClientSecret( dto.getClientSecret() );

        return apiConsumer;
    }
}
