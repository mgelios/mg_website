package mg.weather.mock;

import mg.weather.entity.CurrentWeather;
import mg.weather.repository.CurrentWeatherRepository;
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
}
