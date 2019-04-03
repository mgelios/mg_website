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