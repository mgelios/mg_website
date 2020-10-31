package mg.news;

import lombok.Getter;
import lombok.Setter;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/news.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.news")
@Getter
@Setter
public class NewsConfiguration {

    private String radiotNewsApiHost;
    private String radiotPodcastsApiHost;
    private String radiotArticlesPathPart;
    private String radiotPodcastsPathPart;
    private String radiotPodcastCategoriesParameter;
}
