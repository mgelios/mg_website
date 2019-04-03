package mg.finance.models;

import java.time.LocalDateTime;

public class CryptoCurrency {

    private Long id;
    private String name;
    private String symbol;
    private long rank;
    private double priceUSD;
    private double priceBTC;
    private double volumeUSD24h;
    private double marketCapUSD;
    private double availableSupply;
    private double totalSupply;
    private double maxSupply;
    private double percentChangeIn1h;
    private double percentChangeIn24h;
    private double percentChangeIn7h;
    private LocalDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public double getPriceBTC() {
        return priceBTC;
    }

    public void setPriceBTC(double priceBTC) {
        this.priceBTC = priceBTC;
    }

    public double getVolumeUSD24h() {
        return volumeUSD24h;
    }

    public void setVolumeUSD24h(double volumeUSD24h) {
        this.volumeUSD24h = volumeUSD24h;
    }

    public double getMarketCapUSD() {
        return marketCapUSD;
    }

    public void setMarketCapUSD(double marketCapUSD) {
        this.marketCapUSD = marketCapUSD;
    }

    public double getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(double availableSupply) {
        this.availableSupply = availableSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(double maxSupply) {
        this.maxSupply = maxSupply;
    }

    public double getPercentChangeIn1h() {
        return percentChangeIn1h;
    }

    public void setPercentChangeIn1h(double percentChangeIn1h) {
        this.percentChangeIn1h = percentChangeIn1h;
    }

    public double getPercentChangeIn24h() {
        return percentChangeIn24h;
    }

    public void setPercentChangeIn24h(double percentChangeIn24h) {
        this.percentChangeIn24h = percentChangeIn24h;
    }

    public double getPercentChangeIn7h() {
        return percentChangeIn7h;
    }

    public void setPercentChangeIn7h(double percentChangeIn7h) {
        this.percentChangeIn7h = percentChangeIn7h;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
