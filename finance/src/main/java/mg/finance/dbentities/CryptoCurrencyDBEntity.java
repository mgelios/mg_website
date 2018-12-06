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

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "rank")
    private long rank;

    @Column(name = "usd_price")
    private double usdPrice;

    @Column(name = "btc_price")
    private double btcPrice;

    @Column(name = "change_24h")
    private double change24h;

}
