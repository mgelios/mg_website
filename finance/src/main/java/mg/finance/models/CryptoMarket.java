package mg.finance.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CryptoMarket {

    private Long id;
    private Long totalUsd;
    private Long totalUsdDayVolume;
    private Long activeMarkets;
    private Long activeCurrencies;
    private double bitcoinPercent;
    private LocalDateTime lastUpdated;
}