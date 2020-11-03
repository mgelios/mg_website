package mg.blog.mapper;

import mg.blog.dto.ArticleDto;
import mg.blog.entity.ArticleDBEntity;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, CommentMapper.class, SubcategoryMapper.class, TagMapper.class})
public abstract class ArticleMapper {

    public static final ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    public abstract ArticleDBEntity mapToEntity(ArticleDto dto);

    public abstract ArticleDto mapToDTO(ArticleDBEntity entity);

//    @AfterMapping
//    private void addBackReference (@MappingTarget ArticleDBEntity entity) {
//        entity.getComments().forEach(comment -> comment.setArticle(entity));
//    }

//    @AfterMapping
//    private void addBackReference (@MappingTarget Article dto) {
//        dto.getComments().forEach(comment -> comment.setArticle(dto));
//    }
}
