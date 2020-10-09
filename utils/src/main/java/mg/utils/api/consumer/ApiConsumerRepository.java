package mg.utils.api.consumer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApiConsumerRepository extends CrudRepository<ApiConsumer, UUID> {
}
