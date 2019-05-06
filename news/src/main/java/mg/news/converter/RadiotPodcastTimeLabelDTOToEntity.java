package mg.news.converter;

import mg.news.dbentities.RadiotPodcastTimeLabelDBEntity;
import mg.news.models.RadiotPodcastTimeLabel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class RadiotPodcastTimeLabelDTOToEntity implements Converter<RadiotPodcastTimeLabel, RadiotPodcastTimeLabelDBEntity> {

    @Override
    public RadiotPodcastTimeLabelDBEntity convert(RadiotPodcastTimeLabel source) {
        RadiotPodcastTimeLabelDBEntity target = new RadiotPodcastTimeLabelDBEntity();
        target.setTopic(source.getTopic());
        target.setTime(Timestamp.valueOf(source.getTime()));
        target.setDuration(source.getDuration());
        target.setId(source.getId());
        return target;
    }
}
