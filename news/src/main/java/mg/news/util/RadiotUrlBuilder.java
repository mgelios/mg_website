package mg.news.util;

import mg.news.NewsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(NewsConfiguration.class)
public class RadiotUrlBuilder {

    @Autowired
    NewsConfiguration newsConfiguration;

    public String buildNewsUrl(int numberOfNews) {
        StringBuilder builder = new StringBuilder();
        builder.append(newsConfiguration.getRadiotApiUrl())
                .append(newsConfiguration.getRadiotArticlesSuffix())
                .append(String.valueOf(numberOfNews));
        return builder.toString();
    }

    public String buildPodcastUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(newsConfiguration.getRadiotPodcastsApiUrl())
                .append(newsConfiguration.getRadiotPodcastsSuffix());
        return builder.toString();
    }
}
