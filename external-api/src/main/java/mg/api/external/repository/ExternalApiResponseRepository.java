package mg.api.external.repository;

import mg.api.external.entity.ExternalApiResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExternalApiResponseRepository extends CrudRepository<ExternalApiResponse, UUID> {
}
