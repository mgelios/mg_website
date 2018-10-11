package mg.weather;

import lombok.Data;
import mg.utils.JSONConsumer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/weather.properties")
@ConfigurationProperties(prefix = "mg.weather")
@Data
public class WeatherConfiguration{

    public String baseUrl;
    public String weatherSuffix;
    public String forecastSuffix;
    public String apiKey;
    public String units;
    public String lang;
    public String defaultCity;
    public String firstQueryDelimiter;
    public String queryDelimiter;

}
