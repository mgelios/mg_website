package mg.news.converter;

import mg.news.dbentities.RadiotPodcastTimeLabelDBEntity;
import mg.news.models.RadiotPodcastTimeLabel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RadiotPodcastTimeLabelEntityToDTO implements Converter<RadiotPodcastTimeLabelDBEntity, RadiotPodcastTimeLabel> {

    @Override
    public RadiotPodcastTimeLabel convert(RadiotPodcastTimeLabelDBEntity source) {
        RadiotPodcastTimeLabel target = new RadiotPodcastTimeLabel();
        target.setDuration(source.getDuration());
        target.setId(source.getId());
        target.setTime(source.getTime().toLocalDateTime());
        target.setTopic(source.getTopic());
        return target;
    }
}
