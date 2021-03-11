package mg.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name="mg_currency_statistics")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyStatistics {

    @Id
    @GeneratedValue
    private UUID uuid;
    private Long currencyId;
    private OffsetDateTime date;
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "currency")
    private Currency currency;
    private double rate;
}
