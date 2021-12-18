package mg.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

//@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="mg_one_call")
public class OneCall {

    @Id
    @GeneratedValue
    private UUID uuid;
    private double lat;
    private double lon;
    private String timezone;
    private String timezoneOffset;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "current")
    private CurrentWeatherInfo current;

//    @OneToMany(mappedBy = "oneCall", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<DailyWeatherForecastInfo> daily;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "geocoding_info")
    private GeocodingInfo geocodingInfo;
}
