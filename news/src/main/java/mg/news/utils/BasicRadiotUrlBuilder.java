package mg.news.utils;

import mg.news.NewsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(NewsConfiguration.class)
public class BasicRadiotUrlBuilder implements RadiotUrlBuilder {

    @Autowired
    NewsConfiguration newsConfiguration;

    @Override
    public String buildNewsUrl(int numberOfNews) {
        StringBuilder builder = new StringBuilder();
        builder.append(newsConfiguration.getRadiotApiUrl())
                .append(newsConfiguration.getRadiotArticlesSuffix())
                .append(String.valueOf(numberOfNews));
        return builder.toString();
    }

    @Override
    public String buildPodcastUrl() {
        return null;
    }
}
