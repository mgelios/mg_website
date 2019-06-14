package mg.blog.mapper;

import mg.blog.dbentity.CommentDBEntity;
import mg.blog.model.Comment;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public abstract class CommentMapper {

    public static final CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    public abstract CommentDBEntity mapToEntity(Comment dto);

    public abstract Comment mapToDTO(CommentDBEntity entity);
}
