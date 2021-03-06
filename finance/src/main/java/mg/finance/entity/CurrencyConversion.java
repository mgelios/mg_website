package mg.finance.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name="mg_currency_conversion")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

    @Id
    @GeneratedValue
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "currency_from", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Currency currencyFrom;
    @ManyToOne
    @JoinColumn(name = "currency_to", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Currency currencyTo;
    private double value;
    private OffsetDateTime updatedOn;
}
