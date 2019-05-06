package mg.news.converter;

import mg.news.dbentities.RadiotPodcastDBEntity;
import mg.news.models.RadiotPodcast;
import mg.news.models.RadiotPodcastTimeLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.stream.Collectors;

@Component
public class RadiotPodcastDTOToEntity implements Converter<RadiotPodcast, RadiotPodcastDBEntity> {

    @Autowired
    RadiotPodcastTimeLabelDTOToEntity radiotPodcastTimeLabelDTOToEntity;

    @Override
    public RadiotPodcastDBEntity convert(RadiotPodcast source) {
        RadiotPodcastDBEntity target = new RadiotPodcastDBEntity();
        target.setUrl(source.getUrl());
        target.setTitle(source.getTitle());
        target.setShowNotes(source.getShowNotes());
        target.setImage(source.getImage());
        target.setDate(Timestamp.valueOf(source.getDate()));
        target.setBody(source.getBody());
        target.setAudioUrl(source.getAudioUrl());
        target.setId(source.getId());
        target.setTimeLabels(
                source.getTimeLabels().stream()
                        .map(radiotPodcastTimeLabelDTOToEntity::convert)
                        .collect(Collectors.toSet())
        );
        return target;
    }
}
