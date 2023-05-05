package mg.weather.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_daily_weather_forecast")
public class DailyWeatherForecast {

    @Id
    @GeneratedValue
    private UUID uuid;
    private OffsetDateTime dt;
    private OffsetDateTime sunrise;
    private OffsetDateTime sunset;
    private OffsetDateTime moonrise;
    private OffsetDateTime moonset;
    private double moonPhase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "temp")
    private TemperatureInfo temp;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feels_like")
    private TemperatureFeelsLikeInfo feelsLike;
    private double pressure;
    private double humidity;
    private double dewPoint;
    private double windSpeed;
    private double windDeg;
    private double windGust;

    @OneToMany(mappedBy = "dailyWeatherForecastInfo", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Weather> weather;
    private double clouds;
    private double pop;
    private double uvi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "one_call")
    private OneCall oneCall;
}
