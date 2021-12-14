package mg.weather.dto.openweather;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GeocodingInfoDto {

    private String name;
    private Map<String, String> localNames;
    private double lat;
    private double lon;
    private String country;
}
