package mg.api.external.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.api.external.consumer.dto.ApiConsumerCreationRequestDto;
import mg.api.external.consumer.dto.ApiConsumerUpdateRequestDto;
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
        return apiConsumerRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Requested api consumer is absent"));
    }

    public ApiConsumer findByName(String apiConsumerName) {
        return apiConsumerRepository.findByName(apiConsumerName)
                .orElseThrow(() -> new RuntimeException("Requested api consumer is absent"));
    }

    public ApiConsumer createApiConsumer(ApiConsumerCreationRequestDto apiConsumerDto) {
        apiConsumerRepository.findByName(apiConsumerDto.getName()).ifPresent(o -> {
            throw new RuntimeException("Api consumer's name you've sent is already present");
        });
        ApiConsumer apiConsumerToCreate = apiConsumerMapper.mapToEntity(apiConsumerDto);
        return apiConsumerRepository.save(apiConsumerToCreate);
    }

    public ApiConsumer updateApiConsumer(ApiConsumerUpdateRequestDto apiConsumerDto) {
        ApiConsumer apiConsumerToUpdate = apiConsumerRepository.findById(apiConsumerDto.getUuid())
                .orElseThrow(() -> new RuntimeException("Api consumer you're trying to update not exists"));
        apiConsumerRepository.findByName(apiConsumerDto.getName()).ifPresent(apiConsumerToCheck -> {
            if (!apiConsumerToCheck.getUuid().equals(apiConsumerDto.getUuid())) {
                throw new RuntimeException("Another api consumer with name you've provided already exists");
            }
        });
        apiConsumerToUpdate.setApiKey(apiConsumerDto.getApiKey());
        apiConsumerToUpdate.setToken(apiConsumerDto.getToken());
        apiConsumerToUpdate.setName(apiConsumerDto.getName());
        apiConsumerToUpdate.setClientId(apiConsumerDto.getClientId());
        apiConsumerToUpdate.setClientSecret(apiConsumerDto.getClientSecret());
        return apiConsumerRepository.save(apiConsumerToUpdate);
    }

    public void deleteApiConsumer(UUID uuid) {
        apiConsumerRepository.delete(
                apiConsumerRepository.findById(uuid)
                        .orElseThrow(() -> new RuntimeException("Api consumer you're trying to delete is not exists"))
        );
    }

    public String fillUrlWithApiConsumerData(String url, String apiConsumerName, ApiConsumerAuthType authType) {
        String result = null;
        ApiConsumer apiConsumer = findByName(apiConsumerName);
        if (ApiConsumerAuthType.API_KEY.equals(authType)) {
            result = String.format(url, apiConsumer.getApiKey());
        }
        return result;
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
