package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OneCallDto {

    private long lat;
    private long lon;
    private String timezone;
    private String timezoneOffset;
    private CurrentWeatherInfoDto current;
    private List<DailyWeatherForecastInfoDto> daily;
}
