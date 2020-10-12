package mg.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name="mg_currency")
public class Currency {

    @Id
    @GeneratedValue
    private UUID uuid;
    private long systemId;
    private Timestamp date;
    private String abbreviation;
    private double scale;
    private String name;
    private double rate;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "currency", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<CurrencyStatistics> statistics;
}
