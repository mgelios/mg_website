package mg.weather.service;

import lombok.AllArgsConstructor;
import mg.weather.WeatherConfiguration;
import mg.weather.dto.openweather.GeocodingInfoDto;
import mg.weather.dto.openweather.OneCallDto;
import mg.weather.entity.OneCall;
import mg.weather.mapper.GeocodingInfoMapper;
import mg.weather.mapper.OneCallMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CurrentWeatherService {

    private final WeatherConfiguration weatherConfiguration;
    private final OneCallMapper oneCallMapper;
    private final GeocodingInfoMapper geocodingInfoMapper;
    private final OpenWeatherApiService weatherExternalApiService;


    public CurrentWeatherDto getDefaultCurrentWeather() {
        return getCurrentWeatherByCityName(weatherConfiguration.getDefaultCity());
    }

    public CurrentWeatherDto getCurrentWeatherByCityName(String cityName) {
        GeocodingInfoDto geocodingInfoDto = weatherExternalApiService.fetchGeocodingInfo(cityName).get(0);
        OneCallDto oneCallDto = weatherExternalApiService.fetchOneCallWeather(geocodingInfoDto.getLat(), geocodingInfoDto.getLon());
        OneCall oneCall = oneCallMapper.mapToEntity(oneCallDto);
        oneCall.setGeocodingInfo(geocodingInfoMapper.mapToEntity(geocodingInfoDto));
        return null;
    }

}
