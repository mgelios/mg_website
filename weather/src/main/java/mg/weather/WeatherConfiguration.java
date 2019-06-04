package mg.weather;

import lombok.Data;
import mg.utils.JSONConsumer;
import mg.utils.properties.YamlPropertyLoaderFactory;
import mg.weather.task.WeatherSyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/weather.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.weather")
@Data
public class WeatherConfiguration{

    @Autowired
    WeatherSyncTask weatherSyncTask;

    private String baseUrl;
    private String weatherSuffix;
    private String forecastSuffix;

    private String apiKey;
    private String units;
    private String lang;
    private String defaultCity;

    private String firstQueryDelimiter;
    private String queryDelimiter;
    private String equalitySymbol;

    private String apiKeyVariable;
    private String unitsVariable;
    private String langVariable;
}
