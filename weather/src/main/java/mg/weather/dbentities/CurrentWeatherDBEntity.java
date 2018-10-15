package mg.weather.dbentities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@Table(name="mg_current_weather")
public class CurrentWeatherDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;

    @Column(name = "main_info")
    private String mainInfo;
    @Column(name = "description")
    private String description;
    @Column(name = "icon")
    private String icon;

    @Column(name = "temperature")
    private double temperature;
    @Column(name = "pressure")
    private double pressure;
    @Column(name = "humidity")
    private double humidity;
    @Column(name = "min_temp")
    private double minimalTemperature;
    @Column(name = "max_temp")
    private double maximumTemperature;
    @Column(name = "visibility")
    private double visibility;

    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "wind_degree")
    private double windDegree;

    @Column(name = "sunrise")
    private Timestamp sunrise;
    @Column(name = "sunset")
    private Timestamp sunset;

    @Column(name = "uvi")
    private double uvi;

}
