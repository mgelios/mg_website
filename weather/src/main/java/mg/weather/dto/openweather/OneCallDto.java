package mg.weather.dto.openweather;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OneCallDto {

    private double lat;
    private double lon;
    private String timezone;
    private String timezoneOffset;
    private CurrentWeatherDto current;
    private List<DailyWeatherForecastInfoDto> daily;
}
