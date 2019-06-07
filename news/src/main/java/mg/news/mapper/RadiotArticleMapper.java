package mg.news.mapper;

import mg.news.dbentities.RadiotArticleDBEntity;
import mg.news.models.RadiotArticle;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class RadiotArticleMapper {

    public static final RadiotArticleMapper INSTANCE = Mappers.getMapper(RadiotArticleMapper.class);

    public abstract RadiotArticleDBEntity mapToEntity(RadiotArticle dto);

    public abstract RadiotArticle mapToDTO(RadiotArticleDBEntity entity);
}
