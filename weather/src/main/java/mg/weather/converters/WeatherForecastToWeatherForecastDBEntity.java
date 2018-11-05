package mg.weather.converters;

import mg.weather.dbentities.WeatherForecastDBEntity;
import mg.weather.models.WeatherForecast;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class WeatherForecastToWeatherForecastDBEntity implements Converter<WeatherForecast, WeatherForecastDBEntity> {

    @Override
    public WeatherForecastDBEntity convert(WeatherForecast source){
        WeatherForecastDBEntity target = new WeatherForecastDBEntity();
        target.setId(source.getId());
        target.setTime(Timestamp.valueOf(source.getTime()));
        target.setTemperature(source.getTemperature());
        target.setMinimalTemperature(source.getMinimalTemperature());
        target.setMaximumTemperature(source.getMaximumTemperature());
        target.setPressure(source.getPressure());
        target.setSeaLevel(source.getSeaLevel());
        target.setGroundLevel(source.getGroundLevel());
        target.setHumidity(source.getHumidity());
        target.setMainInfo(source.getMainInfo());
        target.setDescription(source.getDescription());
        target.setIcon(source.getIcon());
        target.setWindDegree(source.getWindDegree());
        target.setWindSpeed(source.getWindSpeed());
        target.setCityName(source.getCityName());
        return target;
    }

}
