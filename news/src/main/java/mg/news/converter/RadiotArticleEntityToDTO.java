package mg.news.converter;

import mg.news.dbentities.RadiotArticleDBEntity;
import mg.news.models.RadiotArticle;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RadiotArticleEntityToDTO implements Converter<RadiotArticleDBEntity, RadiotArticle> {

    @Override
    public RadiotArticle convert(RadiotArticleDBEntity source) {
        RadiotArticle target = new RadiotArticle();
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        target.setSnippet(source.getSnippet());
        target.setSlug(source.getSlug());
        target.setRadiotTime(source.getRadiotTime().toLocalDateTime());
        target.setOriginalTime(source.getRadiotTime().toLocalDateTime());
        target.setMainPicture(source.getMainPicture());
        target.setLink(source.getLink());
        target.setLikes(source.getLikes());
        target.setLastUpdated(source.getLastUpdated().toLocalDateTime());
        target.setFeed(source.getFeed());
        target.setContent(source.getContent());
        target.setComments(source.getComments());
        target.setAuthor(source.getAuthor());
        return target;
    }
}
