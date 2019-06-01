package mg.weather.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class WeatherForecast {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private LocalDateTime time;
    @Getter
    @Setter
    private double temperature;
    @Getter
    @Setter
    private double minimalTemperature;
    @Getter
    @Setter
    private double maximumTemperature;
    @Getter
    @Setter
    private double pressure;
    @Getter
    @Setter
    private double seaLevel;
    @Getter
    @Setter
    private double groundLevel;
    @Getter
    @Setter
    private double humidity;
    @Getter
    @Setter
    private String mainInfo;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String icon;
    @Getter
    @Setter
    private double windSpeed;
    @Getter
    @Setter
    private double windDegree;
    @Getter
    @Setter
    private String cityName;
    @Getter
    @Setter
    private LocalDateTime updateTime;
}
