package mg.finance.models;

import java.time.LocalDateTime;

public class CryptoMarket {

    private Long id;

    private Long totalUsd;
    private Long totalUsdDayVolume;
    private Long activeMarkets;
    private Long activeCurrencies;
    private double bitcoinPercent;
    private LocalDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalUsd() {
        return totalUsd;
    }

    public void setTotalUsd(Long totalUsd) {
        this.totalUsd = totalUsd;
    }

    public Long getTotalUsdDayVolume() {
        return totalUsdDayVolume;
    }

    public void setTotalUsdDayVolume(Long totalUsdDayVolume) {
        this.totalUsdDayVolume = totalUsdDayVolume;
    }

    public Long getActiveMarkets() {
        return activeMarkets;
    }

    public void setActiveMarkets(Long activeMarkets) {
        this.activeMarkets = activeMarkets;
    }

    public Long getActiveCurrencies() {
        return activeCurrencies;
    }

    public void setActiveCurrencies(Long activeCurrencies) {
        this.activeCurrencies = activeCurrencies;
    }

    public double getBitcoinPercent() {
        return bitcoinPercent;
    }

    public void setBitcoinPercent(double bitcoinPercent) {
        this.bitcoinPercent = bitcoinPercent;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

//    total_usd = models.IntegerField(default=0.0)
//        total_usd_day_volume = models.IntegerField(default=0.0)
//        active_markets = models.IntegerField(default=0.0)
//        active_currencies = models.IntegerField(default=0)
//        bitcoin_percent = models.FloatField(default=0.0)
//        last_updated = models.DateTimeField(default=timezone.now)