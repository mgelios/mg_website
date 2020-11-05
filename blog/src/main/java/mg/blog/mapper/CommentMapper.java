package mg.blog.mapper;

import mg.blog.entity.Comment;
import mg.blog.dto.CommentDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public abstract class CommentMapper {

    public static final CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    public abstract Comment mapToEntity(CommentDto dto);

    public abstract CommentDto mapToDTO(Comment entity);
}
