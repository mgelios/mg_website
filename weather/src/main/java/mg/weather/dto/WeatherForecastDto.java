package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class WeatherForecastDto {

    private UUID uuid;
    private LocalDateTime time;
    private double temperature;
    private double minimalTemperature;
    private double maximumTemperature;
    private double pressure;
    private double seaLevel;
    private double groundLevel;
    private double humidity;
    private String mainInfo;
    private String description;
    private String icon;
    private double windSpeed;
    private double windDegree;
    private String cityName;
    private LocalDateTime updateTime;
}
