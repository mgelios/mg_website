package mg.weather.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_one_call")
public class OneCall {

    @Id
    @GeneratedValue
    private UUID uuid;
    private double lat;
    private double lon;
    private String timezone;
    private long timezoneOffset;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current")
    private CurrentWeather current;

    @OneToMany(mappedBy = "oneCall", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<DailyWeatherForecast> daily;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geocoding_info")
    private GeocodingInfo geocodingInfo;
}
