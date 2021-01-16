package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class CurrentWeatherDto {

    private UUID uuid;
    private String mainInfo;
    private String description;
    private String icon;
    private String cityName;
    private double longitude;
    private double latitude;
    private double temperature;
    private double pressure;
    private double humidity;
    private double minimalTemperature;
    private double maximumTemperature;
    private double visibility;
    private double windSpeed;
    private double windDegree;
    private double uvi;
    private OffsetDateTime time;
    private OffsetDateTime sunrise;
    private OffsetDateTime sunset;
}
