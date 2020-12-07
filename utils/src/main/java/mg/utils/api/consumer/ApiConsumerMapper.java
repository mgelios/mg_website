package mg.utils.api.consumer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ApiConsumerMapper {

    public static final ApiConsumerMapper INSTANCE = Mappers.getMapper(ApiConsumerMapper.class);

    public abstract ApiConsumerDto mapToDto(ApiConsumer entity);

    public abstract ApiConsumer mapToEntity(ApiConsumerDto dto);
}
