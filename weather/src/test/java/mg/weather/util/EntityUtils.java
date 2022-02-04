package mg.weather.util;

import mg.weather.entity.Weather;

public class EntityUtils {

    public static Weather getDefaultWeatherEntity() {
        Weather entity = new Weather();
        entity.setDescription("defaultDescription");
        entity.setIcon("defaultIcon");
        entity.setMain("defaultMainInfo");
        return entity;
    }
}
