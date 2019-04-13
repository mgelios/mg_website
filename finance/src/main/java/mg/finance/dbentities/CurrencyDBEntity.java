package mg.finance.dbentities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Table(name="mg_currency")
public class CurrencyDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "system_id")
    private long systemId;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "scale")
    private double scale;
    @Column(name = "name")
    private String name;
    @Column(name = "rate")
    private double rate;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "currency", orphanRemoval = true)
    private Set<CurrencyStatisticsDBEntity> statistics;
}
