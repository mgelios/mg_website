package mg.weather.service;

import lombok.AllArgsConstructor;
import mg.utils.api.consumer.ApiConsumerAuthType;
import mg.utils.api.consumer.ApiConsumerService;
import mg.weather.WeatherConfiguration;
import mg.weather.dto.openweather.GeocodingInfoDto;
import mg.weather.dto.openweather.OneCallDto;
import mg.weather.util.OpenWeatherUrlBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class OpenWeatherApiService {

    private final WeatherConfiguration weatherConfiguration;
    private final OpenWeatherUrlBuilder weatherUrlBuilder;
    private final ApiConsumerService apiConsumerService;

    public OneCallDto fetchOneCallWeather(double lat, double lon) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildOneCallUrl(lat, lon),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        return restTemplate.getForObject(url, OneCallDto.class);
    }

    public List<GeocodingInfoDto> fetchGeocodingInfo(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildGeocodingUrl(city, 1),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        return restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<GeocodingInfoDto>>(){})
                .getBody();
    }
}
