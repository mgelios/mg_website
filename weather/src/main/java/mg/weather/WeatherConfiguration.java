package mg.weather;

import lombok.Getter;
import lombok.Setter;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/weather.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.weather")
@Getter
@Setter
public class WeatherConfiguration{

    private String apiClientName;
    private String defaultCity;

    private String defaultCoordLat;
    private String defaultCoordLon;

    private String oneCallUrl;
    private String geocodingUrl;
}
