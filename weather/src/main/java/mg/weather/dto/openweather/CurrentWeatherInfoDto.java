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
public class CurrentWeatherInfoDto {

    private Instant dt;
    private Instant sunrise;
    private Instant sunset;
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
