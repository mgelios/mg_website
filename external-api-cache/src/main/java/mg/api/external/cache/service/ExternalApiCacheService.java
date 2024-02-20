package mg.api.external.cache.service;

import lombok.AllArgsConstructor;
import mg.api.external.cache.repository.ExternalApiResponseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ExternalApiCacheService {

    private final ExternalApiResponseRepository apiResponseRepository;


}
