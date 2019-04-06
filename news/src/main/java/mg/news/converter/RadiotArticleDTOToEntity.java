package mg.news.converter;

import mg.news.dbentities.RadiotArticleDBEntity;
import mg.news.models.RadiotArticle;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class RadiotArticleDTOToEntity implements Converter<RadiotArticle, RadiotArticleDBEntity> {

    @Override
    public RadiotArticleDBEntity convert(RadiotArticle source) {
        RadiotArticleDBEntity target = new RadiotArticleDBEntity();
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        target.setSnippet(source.getSnippet());
        target.setSlug(source.getSlug());
        target.setRadiotTime(Timestamp.valueOf(source.getRadiotTime()));
        target.setOriginalTime(Timestamp.valueOf(source.getRadiotTime()));
        target.setMainPicture(source.getMainPicture());
        target.setLink(source.getLink());
        target.setLikes(source.getLikes());
        target.setLastUpdated(Timestamp.valueOf(source.getLastUpdated()));
        target.setFeed(source.getFeed());
        target.setContent(source.getContent());
        target.setComments(source.getComments());
        target.setAuthor(source.getAuthor());
        return target;
    }
}
