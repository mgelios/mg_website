package mg.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mg_geocoding_info")
public class GeocodingInfo {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;

    @ElementCollection
    @CollectionTable(name = "mg_city_local_names",
            joinColumns = {@JoinColumn(name = "geocoding_uuid", referencedColumnName = "uuid")})
    @MapKeyColumn(name = "location_code")
    @Column(name = "name")
    private Map<String, String> localNames;
    private double lat;
    private double lon;
    private String country;
}
