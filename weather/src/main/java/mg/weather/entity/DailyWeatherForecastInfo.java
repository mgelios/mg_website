package mg.weather.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_daily_weather_forecast_info")
public class DailyWeatherForecastInfo {

    @Id
    @GeneratedValue
    private UUID uuid;
}
