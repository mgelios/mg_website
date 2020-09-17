package mg.finance.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name="mg_currency_statistics")
public class CurrencyStatistics {

    @Id
    @GeneratedValue
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "date")
    private Timestamp date;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "currency")
    private Currency currency;

    @Column(name = "rate")
    private double rate;
}
