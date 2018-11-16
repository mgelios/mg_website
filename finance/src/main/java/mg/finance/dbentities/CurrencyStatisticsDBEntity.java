package mg.finance.dbentities;

import lombok.Data;
import mg.finance.models.Currency;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="mg_currency_statistics")
public class CurrencyStatisticsDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Timestamp date;
    @Column(name = "currency")
    private CurrencyDBEntity currency;
    @Column(name = "rate")
    private double rate;

}
