package mg.api.external;

import lombok.Getter;
import lombok.Setter;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/external-api-cache.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.api.external.cache")
@Getter
@Setter
public class ExternalApiCacheConfiguration {


}
