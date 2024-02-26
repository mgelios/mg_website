package mg.api.external.service;

import lombok.AllArgsConstructor;
import mg.api.external.repository.ExternalApiResponseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ExternalApiCacheService {

    private final ExternalApiResponseRepository apiResponseRepository;


}
