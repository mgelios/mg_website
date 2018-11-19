package mg.finance.dbentities;

import lombok.Data;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_from", nullable = false)
    private CurrencyDBEntity currencyFrom;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_to", nullable = false)
    private CurrencyDBEntity currencyTo;

    @Column(name = "value")
    private double value;

}
