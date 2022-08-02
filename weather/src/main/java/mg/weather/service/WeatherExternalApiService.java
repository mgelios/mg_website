package mg.weather.service;

import lombok.AllArgsConstructor;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.utils.api.consumer.ApiConsumerAuthType;
import mg.utils.api.consumer.ApiConsumerService;
import mg.weather.WeatherConfiguration;
import mg.weather.dto.openweather.GeocodingInfoDto;
import mg.weather.dto.openweather.OneCallDto;
import mg.weather.util.OpenWeatherUrlBuilder;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class WeatherExternalApiService {

    private final WeatherConfiguration weatherConfiguration;
    private final OpenWeatherUrlBuilder weatherUrlBuilder;
    private final ApiConsumerService apiConsumerService;
    private final JSONConsumer jsonConsumer;

    public JSONObject fetchCurrentWeather(String cityName) {
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildCurrentWeatherUrl(cityName),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        return jsonConsumer.getJsonObject(url);
    }

    public OneCallDto fetchOneCallWeather(double lat, double lon) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildOneCallUrl(String.valueOf(lat), String.valueOf(lon)),
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

    public JSONObject fetchWeatherForecast(String cityName) {
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildForecastUrl(cityName),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        return jsonConsumer.getJsonObject(url);
    }
}
