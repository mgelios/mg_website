package mg.blog.mapper;

import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public abstract class ArticleMapper {
}
