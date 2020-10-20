package mg.weather;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mg.utils.properties.YamlPropertyLoaderFactory;
import mg.weather.task.WeatherSyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/weather.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.weather")
@Getter
@Setter
public class WeatherConfiguration{

    @Autowired
    WeatherSyncTask weatherSyncTask;

    private String baseUrl;
    private String weatherSuffix;
    private String forecastSuffix;

    private String apiClientName;
    private String units;
    private String lang;
    private String defaultCity;

    private String weatherQuerySuffix;
    private String queryDelimiter;
    private String querySymbol;
    private String equalitySymbol;

    private String apiKeyVariable;
    private String unitsVariable;
    private String langVariable;

    private String uviSuffix;
    private String coordLatSuffix;
    private String coordLonSuffix;
    private String defaultCoordLat;
    private String defaultCoordLon;
}
