package mg.finance.dbentities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="mg_crypto_currency")
public class CryptoCurrencyDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}
