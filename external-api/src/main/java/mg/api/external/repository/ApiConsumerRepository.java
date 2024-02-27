package mg.api.external.repository;

import mg.api.external.entity.ApiConsumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApiConsumerRepository extends CrudRepository<ApiConsumer, UUID> {

    Optional<ApiConsumer> findByName(String name);

    List<ApiConsumer> findAllByUuidNotNull();
}
