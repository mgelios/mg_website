package mg.weather.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

//@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="mg_temperature_feels_like_info")
public class TemperatureFeelsLikeInfo {

    @Id
    @GeneratedValue
    private UUID uuid;
    private double day;
    private double night;
    private double eve;
    private double morn;
}
