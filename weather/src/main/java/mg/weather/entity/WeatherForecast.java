package mg.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_weather_forecast")
public class WeatherForecast {

    @Id
    @GeneratedValue
    private UUID uuid;
    private OffsetDateTime time;
    private double temperature;
    private double feelsLike;
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
    private OffsetDateTime updateTime;
}
