package mg.weather.entity;

import lombok.*;

import javax.persistence.*;
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
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "currentWeatherInfo")
    private CurrentWeatherInfo currentWeatherInfo;
}
