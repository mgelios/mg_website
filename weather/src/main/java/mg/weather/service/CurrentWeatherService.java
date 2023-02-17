package mg.weather.service;

import lombok.AllArgsConstructor;
import mg.weather.WeatherConfiguration;
import mg.weather.dto.openweather.GeocodingInfoDto;
import mg.weather.dto.openweather.OneCallDto;
import mg.weather.entity.OneCall;
import mg.weather.dto.CurrentWeatherDto;
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
        GeocodingInfoDto geocodingInfoDto = weatherExternalApiService.fetchGeocodingInfo(weatherConfiguration.getDefaultCity()).get(0);
        OneCallDto oneCallDto = weatherExternalApiService.fetchOneCallWeather(geocodingInfoDto.getLat(), geocodingInfoDto.getLon());
        OneCall oneCall = oneCallMapper.mapToEntity(oneCallDto);
        oneCall.setGeocodingInfo(geocodingInfoMapper.mapToEntity(geocodingInfoDto));
        return getCurrentWeatherByCityName(weatherConfiguration.getDefaultCity());
    }

    public CurrentWeatherDto getCurrentWeatherByCityName(String cityName) {
//        Optional<CurrentWeather> optionalCurrentWeather = currentWeatherRepository.findByCityName(cityName);
//        CurrentWeather result = null;
//        if (optionalCurrentWeather.isPresent()) {
//            result = optionalCurrentWeather.get();
//        }
//        if (result == null || result.getTime().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
//            result = updateCurrentWeatherByCityName(cityName);
//        }
//        return currentWeatherMapper.mapToDTO(result);
        return null;
    }

}
