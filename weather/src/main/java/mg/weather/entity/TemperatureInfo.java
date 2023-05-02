package mg.weather.entity;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_temperature_info")
public class TemperatureInfo {

    @Id
    @GeneratedValue
    private UUID uuid;
    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;
}
