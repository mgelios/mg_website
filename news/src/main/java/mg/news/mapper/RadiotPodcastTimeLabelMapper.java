package mg.news.mapper;

import mg.news.entity.RadiotPodcastTimeLabel;
import mg.news.dto.RadiotPodcastTimeLabelDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class, componentModel = "spring")
public abstract class RadiotPodcastTimeLabelMapper {

    @Mapping(target = "podcast", ignore = true)
    public abstract RadiotPodcastTimeLabelDto mapToDTO(RadiotPodcastTimeLabel entity);

    @Mapping(target = "podcast", ignore = true)
    public abstract RadiotPodcastTimeLabel mapToEntity(RadiotPodcastTimeLabelDto dto);
}
