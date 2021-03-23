package mg.weather.service;

import lombok.AllArgsConstructor;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import mg.utils.api.consumer.ApiConsumerAuthType;
import mg.utils.api.consumer.ApiConsumerService;
import mg.weather.WeatherConfiguration;
import mg.weather.util.OpenWeatherUrlBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherExternalApiService {

    private final WeatherConfiguration weatherConfiguration;
    private final OpenWeatherUrlBuilder weatherUrlBuilder;
    private final ApiConsumerService apiConsumerService;
    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;

    public JSONObject fetchCurrenctWeather(String cityName) {
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildCurrentWeatherUrl(cityName),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        return jsonConsumer.getJsonObject(url);
    }

    public double fetchUvi(double lat, double lon) {
        double uvi;
        String url = apiConsumerService.fillUrlWithApiConsumerData(
                weatherUrlBuilder.buildUviUrl(String.valueOf(lat), String.valueOf(lon)),
                weatherConfiguration.getApiClientName(),
                ApiConsumerAuthType.API_KEY
        );
        JSONObject currentUviJson = jsonConsumer.getJsonObject(url);
        uvi = currentUviJson != null ? jsonHelper.getDouble(currentUviJson, "value") : 0.0;
        return uvi;
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
