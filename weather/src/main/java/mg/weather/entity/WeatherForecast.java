package mg.weather.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="mg_weather_forecast")
public class WeatherForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "temperature")
    private double temperature;
    @Column(name = "min_temp")
    private double minimalTemperature;
    @Column(name = "max_temp")
    private double maximumTemperature;
    @Column(name = "pressure")
    private double pressure;
    @Column(name = "sea_level")
    private double seaLevel;
    @Column(name = "ground_level")
    private double groundLevel;
    @Column(name = "humidity")
    private double humidity;

    @Column(name = "main_info")
    private String mainInfo;
    @Column(name = "description")
    private String description;
    @Column(name = "icon")
    private String icon;

    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "wind_degree")
    private double windDegree;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "update_time")
    private Timestamp updateTime;

}
