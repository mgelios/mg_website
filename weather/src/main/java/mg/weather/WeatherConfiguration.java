package mg.weather;

import lombok.Data;
import mg.utils.JSONConsumer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/weather.properties")
@ConfigurationProperties(prefix = "mg.weather")
@Data
public class WeatherConfiguration{

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
