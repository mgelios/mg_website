package mg.weather.repositories;

import mg.weather.dbentities.CurrentWeatherDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentWeatherRepository extends CrudRepository<CurrentWeatherDBEntity, Long> {

    //Optional<CurrentWeatherDBEntity> findByCityName();

}
