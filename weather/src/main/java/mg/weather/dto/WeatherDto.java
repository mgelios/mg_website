package mg.weather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDto {

    private String main;
    private String description;
    private String icon;
}
