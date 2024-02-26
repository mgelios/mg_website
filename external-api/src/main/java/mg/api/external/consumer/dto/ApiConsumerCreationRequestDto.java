package mg.api.external.consumer.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class ApiConsumerCreationRequestDto {

    @NotBlank(message = "Api consumer name is required")
    @Size(min = 6, message = "Minimal length of api consumer name is 6 characters")
    private String name;
    private String apiKey;
    private String token;
    private String clientId;
    private String clientSecret;
}
