package mg.finance.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name="mg_currency_conversion")
public class CurrencyConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
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
    @Column(name = "value")
    private double value;
}
