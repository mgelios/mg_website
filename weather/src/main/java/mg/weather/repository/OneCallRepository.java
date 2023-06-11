package mg.weather.repository;

import mg.weather.entity.OneCall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OneCallRepository extends CrudRepository<OneCall, UUID> {
}
