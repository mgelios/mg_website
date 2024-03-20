package mg.api.external.mapper;

import javax.annotation.processing.Generated;
import mg.api.external.dto.ExternalApiResponseDto;
import mg.api.external.entity.ExternalApiResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T18:23:22+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.2 (N/A)"
)
@Component
public class ExternalApiResponseMapperImpl implements ExternalApiResponseMapper {

    @Override
    public ExternalApiResponse mapToEntity(ExternalApiResponseDto dto) {
        if ( dto == null ) {
            return null;
        }

        ExternalApiResponse externalApiResponse = new ExternalApiResponse();

        externalApiResponse.setUuid( dto.getUuid() );
        externalApiResponse.setBody( dto.getBody() );
        externalApiResponse.setDateTime( dto.getDateTime() );

        return externalApiResponse;
    }

    @Override
    public ExternalApiResponseDto mapToDto(ExternalApiResponse entity) {
        if ( entity == null ) {
            return null;
        }

        ExternalApiResponseDto externalApiResponseDto = new ExternalApiResponseDto();

        externalApiResponseDto.setUuid( entity.getUuid() );
        externalApiResponseDto.setBody( entity.getBody() );
        externalApiResponseDto.setDateTime( entity.getDateTime() );

        return externalApiResponseDto;
    }
}
