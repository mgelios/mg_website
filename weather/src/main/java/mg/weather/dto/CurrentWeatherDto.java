package mg.weather.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrentWeatherDto {

    private Long id;
    private LocalDateTime time;
    private String cityName;
    private double longitude;
    private double latitude;
    private String mainInfo;
    private String description;
    private String icon;
    private double temperature;
    private double pressure;
    private double humidity;
    private double minimalTemperature;
    private double maximumTemperature;
    private double visibility;
    private double windSpeed;
    private double windDegree;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private double uvi;
}
