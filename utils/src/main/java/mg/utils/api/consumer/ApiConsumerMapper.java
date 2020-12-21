package mg.utils.api.consumer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiConsumerMapper {

    public abstract ApiConsumerDto mapToDto(ApiConsumer entity);

    public abstract ApiConsumer mapToEntity(ApiConsumerDto dto);
}
