package mg.weather.repositories;

import mg.weather.dbentities.WeatherForecastDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherForecastRepository extends CrudRepository<WeatherForecastDBEntity, Long> {

    Optional<WeatherForecastDBEntity> findByCityName(String cityName);

    List<WeatherForecastDBEntity> findAllByCityName(String cityName);

    void deleteAllByCityName(String cityName);
}
