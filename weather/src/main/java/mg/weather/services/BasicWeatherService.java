package mg.weather.services;

import mg.weather.WeatherConfiguration;
import mg.weather.models.CurrentWeather;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicWeatherService implements WeatherService {

    @Autowired
    WeatherConfiguration weatherConfiguration;

    @Override
    public CurrentWeather getDefaultWeatherInfo() {
        CurrentWeather weather = new CurrentWeather();

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(
                weatherConfiguration.getBaseUrl() +
                        weatherConfiguration.getWeatherSuffix() +
                        "?q=minsk&appid=" +
                        weatherConfiguration.getApiKey() +
                        "&units=" +
                        weatherConfiguration.getUnits() +
                        "&lang=" +
                        weatherConfiguration.getLang());
        try {
            HttpResponse response = client.execute(get);
            String body = EntityUtils.toString(response.getEntity());
            body.length();
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return weather;
    }

}
