package mg.weather.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name="mg_weather_forecast")
public class WeatherForecast {

    @Id
    @GeneratedValue
    private UUID uuid;
    private Timestamp time;
    private double temperature;
    //TODO: rename field or column in liquibase script
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
    private Timestamp updateTime;

}
