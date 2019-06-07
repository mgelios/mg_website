package mg.news.mapper;

import mg.news.dbentities.RadiotPodcastDBEntity;
import mg.news.models.RadiotPodcast;
import mg.utils.mapper.DateMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, RadiotPodcastTimeLabelMapper.class})
public abstract class RadiotPodcastMapper {

    public static final RadiotPodcastMapper INSTANCE = Mappers.getMapper(RadiotPodcastMapper.class);

    public abstract RadiotPodcast mapToDTO(RadiotPodcastDBEntity entity);

    public abstract RadiotPodcastDBEntity mapToEntity(RadiotPodcast dto);

    @AfterMapping
    private void addBackReference(@MappingTarget RadiotPodcastDBEntity entity) {
        entity.getTimeLabels().forEach(label -> label.setPodcast(entity));
    }

    @AfterMapping
    private void addBackReference(@MappingTarget RadiotPodcast dto) {
        dto.getTimeLabels().forEach(label -> label.setPodcast(dto));
    }
}
