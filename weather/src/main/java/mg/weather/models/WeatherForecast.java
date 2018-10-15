package mg.weather.models;

import java.time.LocalDateTime;

public class WeatherForecast {

    private LocalDateTime time;

    private double temperature;
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

}
