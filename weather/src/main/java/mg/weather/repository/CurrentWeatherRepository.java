package mg.weather.repository;

import mg.weather.dbentity.CurrentWeatherDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrentWeatherRepository extends CrudRepository<CurrentWeatherDBEntity, Long> {

    Optional<CurrentWeatherDBEntity> findByCityName(String cityName);

    List<CurrentWeatherDBEntity> findAllByCityName(String cityName);

    void deleteAllByCityName(String cityName);
}
