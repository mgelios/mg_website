package mg.utils.api.consumer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ApiConsumerDto {

    private UUID uuid;
    private String name;
    private String apiKey;
    private String token;
    private String clientId;
    private String clientSecret;
}
