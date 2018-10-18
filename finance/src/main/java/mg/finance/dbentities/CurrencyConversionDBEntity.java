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

    @Column(name = "currency_from")
    private CurrencyDBEntity currencyFrom;
    @Column(name = "currency_to")
    private CurrencyDBEntity currencyTo;

    @Column(name = "value")
    private double value;

}
