package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DailyWeatherForecastInfoDto {

    private long dt;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    private double moonPhase;
    private TemperatureInfoDto temp;
    private TemperatureFeelsLikeInfoDto feelsLike;
    private double pressure;
    private double humidity;
    private double dewPoint;
    private double windSpeed;
    private double windDeg;
    private double windGust;
    private List<WeatherDto> weather;
    private double clouds;
    private double pop;
    private double uvi;
}
