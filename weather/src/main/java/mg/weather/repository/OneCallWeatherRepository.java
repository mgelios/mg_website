package mg.weather.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OneCallWeatherRepository extends CrudRepository<OneCallWeatherRepository, UUID> {
}
