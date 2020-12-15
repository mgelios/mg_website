package mg.news.mapper;

import mg.news.entity.RadiotArticle;
import mg.news.dto.RadiotArticleDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class, componentModel = "spring")
public interface RadiotArticleMapper {

    RadiotArticle mapToEntity(RadiotArticleDto dto);

    RadiotArticleDto mapToDTO(RadiotArticle entity);
}
