package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneCallDto {

    private long lat;
    private long lon;
    private String timezone;
    private String timezoneOffset;
    private CurrentWeatherInfoDto current;
}
