package mg.weather.dto.openweather;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DailyWeatherForecastInfoDto {

    private Instant dt;
    private Instant sunrise;
    private Instant sunset;
    private Instant moonrise;
    private Instant moonset;
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
