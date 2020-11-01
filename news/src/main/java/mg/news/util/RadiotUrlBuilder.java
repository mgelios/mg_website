package mg.news.util;

import lombok.AllArgsConstructor;
import mg.news.NewsConfiguration;
import mg.utils.url.UrlBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(NewsConfiguration.class)
@AllArgsConstructor
public class RadiotUrlBuilder {

    private static final String PODCAST_CATEGORIES_PARAMETER_VALUE = "podcast";

    private final NewsConfiguration newsConfiguration;

    public String buildNewsUrl(int numberOfNews) {
        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(newsConfiguration.getRadiotNewsApiHost())
                .addPathPart(newsConfiguration.getRadiotArticlesPathPart())
                .addPathPart(String.valueOf(numberOfNews))
                .build().getUrl();
        return result;
    }

    public String buildPodcastUrl() {
        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(newsConfiguration.getRadiotPodcastsApiHost())
                .addPathPart(newsConfiguration.getRadiotPodcastsPathPart())
                .addPathPart(String.valueOf(10))
                .build().getUrl();
        return result;
    }
}
