package mg.utils.api.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ApiConsumerService {

    private final ApiConsumerRepository apiConsumerRepository;
    private final ApiConsumerMapper apiConsumerMapper;

    public List<ApiConsumer> getListOfApiConsumers() {
        return apiConsumerRepository.findAllByUuidNotNull();
    }

    public ApiConsumer findByUuid(UUID uuid) {
        return apiConsumerRepository.findById(uuid).orElse(null);
    }

    public ApiConsumer createApiConsumer(ApiConsumerDto apiConsumerDto) {
        ApiConsumer apiConsumer = apiConsumerMapper.mapToEntity(apiConsumerDto);
        return apiConsumerRepository.save(apiConsumer);
    }

    public ApiConsumer updateApiConsumer(ApiConsumerDto apiConsumerDto) {
        ApiConsumer apiConsumer = apiConsumerMapper.mapToEntity(apiConsumerDto);
        return apiConsumerRepository.save(apiConsumer);
    }

    public void deleteApiConsumer(UUID uuid) {
        apiConsumerRepository.findById(uuid).ifPresent(apiConsumerRepository::delete);
    }

    public String fillUrlWithApiConsumerData(String url, String apiConsumerName, ApiConsumerAuthType authType) {
        Optional<ApiConsumer> optionalOfConsumer = apiConsumerRepository.findByName(apiConsumerName);
        if (!optionalOfConsumer.isPresent()) {
            log.error("No api consumer with name {} present", apiConsumerName);
            return null;
        }
        ApiConsumer apiConsumer = optionalOfConsumer.get();
        if (ApiConsumerAuthType.API_KEY.equals(authType)) {
            return String.format(url, apiConsumer.getApiKey());
        }
        return null;
    }

    public void performApiCall(String name, ApiConsumerAuthType authType) {
        Optional<ApiConsumer> optionalOfConsumer = apiConsumerRepository.findByName(name);
        if (!optionalOfConsumer.isPresent()) {
            log.error("No api consumer with name {} present", name);
            return;
        }
        ApiConsumer consumer = optionalOfConsumer.get();

        switch (authType) {
            case API_KEY:
                performApiCallWithApiKey(consumer.getApiKey());
                break;
            case TOKEN:
                performApiCallWithToken(consumer.getToken());
                break;
            case CLIENT_ID_AND_SECRET:
                perfromApiCallWithClientIdAndSecret(consumer.getClientId(), consumer.getClientSecret());
                break;
        }
    }



    private void performApiCallWithApiKey(String apiKey) {

    }

    private void performApiCallWithToken(String token) {

    }

    private void perfromApiCallWithClientIdAndSecret(String clientId, String clientSecret) {

    }
}
