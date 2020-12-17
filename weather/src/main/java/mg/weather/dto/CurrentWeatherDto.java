package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CurrentWeatherDto {

    private UUID uuid;
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
