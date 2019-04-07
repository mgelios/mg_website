package mg.news.converter;

import mg.news.dbentities.RadiotPodcastTimeLabelDBEntity;
import mg.news.models.RadiotPodcastTimeLabel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RadiotPodcastTimeLabelDTOToEntity implements Converter<RadiotPodcastTimeLabel, RadiotPodcastTimeLabelDBEntity> {

    @Override
    public RadiotPodcastTimeLabelDBEntity convert(RadiotPodcastTimeLabel source) {
        return null;
    }
}
