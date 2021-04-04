package mg.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_current_weather")
public class CurrentWeather {

    @Id
    @GeneratedValue
    private UUID uuid;
    private OffsetDateTime time;
    private String cityName;
    private double longitude;
    private double latitude;
    private String mainInfo;
    private String description;
    private String icon;
    private double temperature;
    private double feelsLike;
    private double pressure;
    private double humidity;
    private double minimalTemperature;
    private double maximumTemperature;
    private double visibility;
    private double windSpeed;
    private double windDegree;
    private OffsetDateTime sunrise;
    private OffsetDateTime sunset;
    private double uvi;
}
