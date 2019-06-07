package mg.news.mapper;

import mg.news.dbentities.RadiotPodcastTimeLabelDBEntity;
import mg.news.models.RadiotPodcastTimeLabel;
import mg.utils.mapper.DateMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class RadiotPodcastTimeLabelMapper {

    public static final RadiotPodcastTimeLabelMapper INSTANCE = Mappers.getMapper(RadiotPodcastTimeLabelMapper.class);

    @Mapping(target = "podcast", ignore = true)
    public abstract RadiotPodcastTimeLabel mapToDTO(RadiotPodcastTimeLabelDBEntity entity);

    @Mapping(target = "podcast", ignore = true)
    public abstract RadiotPodcastTimeLabelDBEntity mapToEntity(RadiotPodcastTimeLabel dto);
}
