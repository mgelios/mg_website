package mg.news.converter;

import mg.news.dbentities.RadiotPodcastDBEntity;
import mg.news.models.RadiotPodcast;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RadiotPodcastDTOToEntity implements Converter<RadiotPodcast, RadiotPodcastDBEntity> {

    @Override
    public RadiotPodcastDBEntity convert(RadiotPodcast source) {
        RadiotPodcastDBEntity target = new RadiotPodcastDBEntity();
        return target;
    }
}
