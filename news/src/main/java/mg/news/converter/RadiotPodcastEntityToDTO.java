package mg.news.converter;

import mg.news.dbentities.RadiotPodcastDBEntity;
import mg.news.models.RadiotPodcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RadiotPodcastEntityToDTO implements Converter<RadiotPodcastDBEntity, RadiotPodcast> {

    @Autowired
    RadiotPodcastTimeLabelEntityToDTO radiotPodcastTimeLabelEntityToDTO;

    @Override
    public RadiotPodcast convert(RadiotPodcastDBEntity source) {
        RadiotPodcast target = new RadiotPodcast();
        target.setAudioUrl(source.getAudioUrl());
        target.setBody(source.getBody());
        target.setDate(source.getDate().toLocalDateTime());
        target.setId(source.getId());
        target.setImage(source.getImage());
        target.setShowNotes(source.getShowNotes());
        target.setTimeLabels(
                source.getTimeLabels().stream()
                        .map(radiotPodcastTimeLabelEntityToDTO::convert)
                        .collect(Collectors.toSet())
        );
        target.setTitle(source.getTitle());
        target.setUrl(source.getUrl());
        return target;
    }
}
