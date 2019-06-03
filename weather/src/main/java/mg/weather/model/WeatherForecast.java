package mg.weather.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class WeatherForecast {

    private Long id;
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
