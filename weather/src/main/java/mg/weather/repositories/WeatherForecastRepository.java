package mg.weather.repositories;

import mg.weather.dbentities.WeatherForecastDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepository extends CrudRepository<WeatherForecastDBEntity, Long> {
}
