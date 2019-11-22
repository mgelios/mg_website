package mg.weather.repository;

import mg.weather.entity.WeatherForecast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherForecastRepository extends CrudRepository<WeatherForecast, Long> {

    Optional<WeatherForecast> findByCityName(String cityName);

    List<WeatherForecast> findAllByCityName(String cityName);

    void deleteAllByCityName(String cityName);
}
