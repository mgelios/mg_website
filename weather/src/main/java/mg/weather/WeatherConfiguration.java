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

    private String host;
    private String weatherPathPart;
    private String forecastPathPart;
    private String uviPathPart;

    private String placeParameter;
    private String apiKeyParameter;
    private String unitsParameter;
    private String langParameter;
    private String coordLatParameter;
    private String coordLonParameter;

    private String apiKey;
    private String apiClientName;
    private String defaultCity;

    private String defaultCoordLat;
    private String defaultCoordLon;
}
