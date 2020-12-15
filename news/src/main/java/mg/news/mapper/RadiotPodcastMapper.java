package mg.news.mapper;

import mg.news.entity.RadiotPodcast;
import mg.news.dto.RadiotPodcastDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, RadiotPodcastTimeLabelMapper.class}, componentModel = "spring")
public abstract class RadiotPodcastMapper {

    public abstract RadiotPodcastDto mapToDTO(RadiotPodcast entity);

    public abstract RadiotPodcast mapToEntity(RadiotPodcastDto dto);

    @AfterMapping
    private void addBackReference(@MappingTarget RadiotPodcast entity) {
        entity.getTimeLabels().forEach(label -> label.setPodcast(entity));
    }

    @AfterMapping
    private void addBackReference(@MappingTarget RadiotPodcastDto dto) {
        dto.getTimeLabels().forEach(label -> label.setPodcast(dto));
    }
}
