package mg.utils.api.consumer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
