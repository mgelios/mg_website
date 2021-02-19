package mg.utils.api.consumer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ApiConsumerResponseDto {

    private UUID uuid;
    private String name;
    private String apiKey;
    private String token;
    private String clientId;
    private String clientSecret;
}
