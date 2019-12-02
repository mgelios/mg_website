package mg.news.mapper;

import mg.news.entity.RadiotArticle;
import mg.news.dto.RadiotArticleDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class RadiotArticleMapper {

    public static final RadiotArticleMapper INSTANCE = Mappers.getMapper(RadiotArticleMapper.class);

    public abstract RadiotArticle mapToEntity(RadiotArticleDto dto);

    public abstract RadiotArticleDto mapToDTO(RadiotArticle entity);
}
