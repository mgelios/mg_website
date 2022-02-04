package mg.weather.util;

import mg.weather.dto.openweather.WeatherDto;

public class DtoUtils {

    public static WeatherDto getDefaultWeatherDto() {
        WeatherDto dto = new WeatherDto();
        dto.setMain("defaultMainInfo");
        dto.setDescription("defaultDescription");
        dto.setIcon("defaultIcon");
        return dto;
    }
}
