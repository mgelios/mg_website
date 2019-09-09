package mg.blog.mapper;

import mg.blog.dbentity.ArticleDBEntity;
import mg.blog.model.Article;
import mg.utils.mapper.DateMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, CommentMapper.class, SubcategoryMapper.class, TagMapper.class})
public abstract class ArticleMapper {

    public static final ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    public abstract ArticleDBEntity mapToEntity(Article dto);

    public abstract Article mapToDTO(ArticleDBEntity entity);

//    @AfterMapping
//    private void addBackReference (@MappingTarget ArticleDBEntity entity) {
//        entity.getComments().forEach(comment -> comment.setArticle(entity));
//    }

//    @AfterMapping
//    private void addBackReference (@MappingTarget Article dto) {
//        dto.getComments().forEach(comment -> comment.setArticle(dto));
//    }
}
