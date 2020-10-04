package mg.finance.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="mg_crypto_currency")
public class CryptoCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String symbol;
    private long rank;
    @Column(name = "price_usd")
    private double priceUSD;
    @Column(name = "price_btc")
    private double priceBTC;
    @Column(name = "volume_usd_24h")
    private double volumeUSD24h;
    @Column(name = "market_cap_usd")
    private double marketCapUSD;
    private double availableSupply;
    private double totalSupply;
    private double maxSupply;
    @Column(name = "percent_change_in_1h")
    private double percentChangeIn1h;
    @Column(name = "percent_change_in_24h")
    private double percentChangeIn24h;
    @Column(name = "percent_change_in_7d")
    private double percentChangeIn7d;
    private Timestamp lastUpdated;

}
