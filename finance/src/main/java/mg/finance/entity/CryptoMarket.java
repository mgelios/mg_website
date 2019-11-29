package mg.finance.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="mg_crypto_currency_market")
public class CryptoMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_usd")
    private Long totalUsd;
    @Column(name = "total_usd_day_volume")
    private Long totalUsdDayVolume;
    @Column(name = "active_markets")
    private Long activeMarkets;
    @Column(name = "active_currencies")
    private Long activeCurrencies;
    @Column(name = "bitcoin_percent")
    private double bitcoinPercent;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;
}
