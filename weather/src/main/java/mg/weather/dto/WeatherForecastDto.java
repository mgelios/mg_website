package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class WeatherForecastDto {

    private UUID uuid;
    private String mainInfo;
    private String description;
    private String icon;
    private String cityName;
    private double temperature;
    private double minimalTemperature;
    private double maximumTemperature;
    private double pressure;
    private double seaLevel;
    private double groundLevel;
    private double humidity;
    private double windSpeed;
    private double windDegree;
    private OffsetDateTime time;
    private OffsetDateTime updateTime;
}
