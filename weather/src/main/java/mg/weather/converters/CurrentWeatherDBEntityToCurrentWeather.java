package mg.weather.converters;

import mg.weather.dbentities.CurrentWeatherDBEntity;
import mg.weather.models.CurrentWeather;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherDBEntityToCurrentWeather implements Converter<CurrentWeatherDBEntity, CurrentWeather> {

    @Override
    public CurrentWeather convert(CurrentWeatherDBEntity source){
        CurrentWeather target = new CurrentWeather();
        target.setId(source.getId());
        target.setTime(source.getTime().toLocalDateTime());
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
        target.setSunrise(source.getSunrise().toLocalDateTime());
        target.setSunset(source.getSunset().toLocalDateTime());
        target.setUvi(source.getUvi());
        return target;
    }

}
