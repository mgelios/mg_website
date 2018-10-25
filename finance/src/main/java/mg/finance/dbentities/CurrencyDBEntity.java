package mg.finance.dbentities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

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
}