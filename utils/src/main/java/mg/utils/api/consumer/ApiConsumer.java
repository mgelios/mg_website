package mg.utils.api.consumer;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="mg_api_consumer")
public class ApiConsumer {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;
    private String apiKey;
    private String token;
    private String clientId;
    private String clientSecret;
}
