package mg.finance.dbentities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mg.finance.models.Currency;

import javax.persistence.*;

@Entity
@Data
@Table(name="mg_currency_conversion")
public class CurrencyConversionDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "currency_from", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CurrencyDBEntity currencyFrom;
    @ManyToOne
    @JoinColumn(name = "currency_to", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CurrencyDBEntity currencyTo;
    @Column(name = "value")
    private double value;
}
