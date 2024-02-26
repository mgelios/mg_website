package mg.api.external.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ExternalApiResponse {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String body;
    private OffsetDateTime dateTime;
}
