package mg.api.external.cache.repository;

import mg.api.external.cache.entity.ExternalApiResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExternalApiCacheRepository extends CrudRepository<ExternalApiResponse, UUID> {
}
