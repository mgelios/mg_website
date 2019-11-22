package mg.weather.repository;

import mg.weather.entity.CurrentWeather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrentWeatherRepository extends CrudRepository<CurrentWeather, Long> {

    Optional<CurrentWeather> findByCityName(String cityName);

    List<CurrentWeather> findAllByCityName(String cityName);

    void deleteAllByCityName(String cityName);
}
