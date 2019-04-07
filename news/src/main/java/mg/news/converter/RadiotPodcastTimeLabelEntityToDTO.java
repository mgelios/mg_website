package mg.news.converter;

import mg.news.dbentities.RadiotPodcastTimeLabelDBEntity;
import mg.news.models.RadiotPodcastTimeLabel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RadiotPodcastTimeLabelEntityToDTO implements Converter<RadiotPodcastTimeLabelDBEntity, RadiotPodcastTimeLabel> {

    @Override
    public RadiotPodcastTimeLabel convert(RadiotPodcastTimeLabelDBEntity source) {
        return null;
    }
}
