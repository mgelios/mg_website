package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureFeelsLikeInfoDto {

    private double day;
    private double night;
    private double eve;
    private double morn;
}
