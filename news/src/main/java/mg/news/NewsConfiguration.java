package mg.news;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/news.properties")
@ConfigurationProperties(prefix = "mg.news")
@Data
public class NewsConfiguration {
}