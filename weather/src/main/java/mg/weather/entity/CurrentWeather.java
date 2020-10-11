package mg.weather.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@Table(name="mg_current_weather")
@Indexed
public class CurrentWeather {

    @Id
    @GeneratedValue
    private UUID uuid;
    private Timestamp time;
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
    private Timestamp sunrise;
    private Timestamp sunset;
    private double uvi;
}
