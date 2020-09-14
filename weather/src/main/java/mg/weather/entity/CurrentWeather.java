package mg.weather.entity;

import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Data
@Table(name="mg_current_weather")
@Indexed
public class CurrentWeather {

    @Id
    @GeneratedValue
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "time")
    private Timestamp time;

    @Field
    @Column(name = "city_name")
    private String cityName;

    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;

    @Column(name = "main_info")
    private String mainInfo;
    @Field
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
