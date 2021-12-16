package mg.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_current_weather_info")
public class CurrentWeatherInfo {

    @Id
    @GeneratedValue
    private UUID uuid;
    private OffsetDateTime dt;
    private OffsetDateTime sunrise;
    private OffsetDateTime sunset;
    private double temp;
    private double feelsLike;
    private double pressure;
    private double humidity;
    private double dewPoint;
    private double uvi;
    private double clouds;
    private double visibility;
    private double windSpeed;
    private double windDeg;
    private double windGust;

    @OneToMany(mappedBy = "currentWeatherInfo", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Weather> weather;
}
