package mg.api.external.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
public class ApiConsumerUpdateRequestDto {

    @NotBlank(message = "UUID is required")
    @Size(min = 36, message = "Minimal length of uuid is 36 characters")
    private UUID uuid;
    @NotBlank(message = "Api consumer name is required")
    @Size(min = 6, message = "Minimal length of api consumer name is 6 characters")
    private String name;
    private String apiKey;
    private String token;
    private String clientId;
    private String clientSecret;
}
