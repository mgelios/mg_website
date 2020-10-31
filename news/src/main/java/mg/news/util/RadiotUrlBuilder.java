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
        StringBuilder builder = new StringBuilder();
        builder.append(newsConfiguration.getRadiotApiUrl())
                .append(newsConfiguration.getRadiotArticlesSuffix())
                .append(String.valueOf(numberOfNews));

        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host()
                .build().getUrl();
        return builder.toString();
    }

    public String buildPodcastUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(newsConfiguration.getRadiotPodcastsApiUrl())
                .append(newsConfiguration.getRadiotPodcastsSuffix());
        return builder.toString();
    }
}
