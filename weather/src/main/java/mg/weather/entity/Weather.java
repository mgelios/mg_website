package mg.weather.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_weather")
public class Weather {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String main;
    private String description;
    private String icon;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "current_weather_info")
    private CurrentWeather currentWeatherInfo;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "daily_weather_forecast_info")
    private DailyWeatherForecastInfo dailyWeatherForecastInfo;
}
