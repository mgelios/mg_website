package mg.weather.mock;

import mg.utils.api.consumer.ApiConsumerRepository;
import mg.weather.entity.CurrentWeather;
import mg.weather.repository.CurrentWeatherRepository;
import mg.weather.repository.WeatherForecastRepository;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMock {

    public static CurrentWeatherRepository getCurrentWeatherRepository() {
        CurrentWeatherRepository repository = Mockito.spy(CurrentWeatherRepository.class);
        List<CurrentWeather> repositoryData = new ArrayList<>();
        CurrentWeather data = CurrentWeather.builder()
                .cityName("defaultCity")
                .build();
        repositoryData.add(data);
        Mockito.when(repository.findAll()).thenReturn(repositoryData);
        return repository;
    }

    public static ApiConsumerRepository getApiConsumerRepository() {
        ApiConsumerRepository repository = Mockito.spy(ApiConsumerRepository.class);
        return repository;
    }

    public static WeatherForecastRepository getWeatherForecastRepository() {
        WeatherForecastRepository repository = Mockito.spy(WeatherForecastRepository.class);
        return repository;
    }
}
