package mg.news;

import lombok.Data;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/news.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.news")
@Data
public class NewsConfiguration {

    private String radiotApiUrl;
    private String radiotArticlesSuffix;
    private String radiotPodcastsApiUrl;
    private String radiotPodcastsSuffix;

}
