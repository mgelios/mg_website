package mg.weather.converter;

import mg.weather.dbentity.CurrentWeatherDBEntity;
import mg.weather.model.CurrentWeather;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CurrentWeatherDTOToEntity implements Converter<CurrentWeather, CurrentWeatherDBEntity> {

    @Override
    public CurrentWeatherDBEntity convert(CurrentWeather source){
        CurrentWeatherDBEntity target = new CurrentWeatherDBEntity();
        target.setId(source.getId());
        target.setTime(Timestamp.valueOf(source.getTime()));
        target.setCityName(source.getCityName());
        target.setLongitude(source.getLongitude());
        target.setLatitude(source.getLatitude());
        target.setMainInfo(source.getMainInfo());
        target.setDescription(source.getDescription());
        target.setIcon(source.getIcon());
        target.setTemperature(source.getTemperature());
        target.setPressure(source.getPressure());
        target.setHumidity(source.getHumidity());
        target.setMinimalTemperature(source.getMinimalTemperature());
        target.setMaximumTemperature(source.getMaximumTemperature());
        target.setVisibility(source.getVisibility());
        target.setWindSpeed(source.getWindSpeed());
        target.setWindDegree(source.getWindDegree());
        target.setSunrise(Timestamp.valueOf(source.getSunrise()));
        target.setSunset(Timestamp.valueOf(source.getSunset()));
        target.setUvi(source.getUvi());
        return target;
    }

}
