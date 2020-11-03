package mg.blog.mapper;

import mg.blog.entity.TagDBEntity;
import mg.blog.dto.Tag;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public abstract class TagMapper {

    public static final TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    public abstract TagDBEntity mapToEntity(Tag dto);

    public abstract Tag mapToDTO(TagDBEntity entity);
}
