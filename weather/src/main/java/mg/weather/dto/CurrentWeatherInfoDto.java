package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CurrentWeatherInfoDto {

    private long dt;
    private long sunrise;
    private long sunset;
    private double temp;
    private double feelsLike;
    private double pressure;
    private double humidity;
    private double dewPoint;
    private double uvi;
    private double clouds;
    private double visibility;
    private double windSpeed;
    private double windDeg;
    private double windGust;
    private List<WeatherDto> weather;
}
