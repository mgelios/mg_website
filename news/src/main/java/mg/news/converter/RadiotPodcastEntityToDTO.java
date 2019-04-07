package mg.news.converter;

import mg.news.dbentities.RadiotPodcastDBEntity;
import mg.news.models.RadiotPodcast;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RadiotPodcastEntityToDTO implements Converter<RadiotPodcastDBEntity, RadiotPodcast> {

    @Override
    public RadiotPodcast convert(RadiotPodcastDBEntity source) {
        return null;
    }
}
