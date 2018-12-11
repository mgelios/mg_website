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
}

//    total_usd = models.IntegerField(default=0.0)
//        total_usd_day_volume = models.IntegerField(default=0.0)
//        active_markets = models.IntegerField(default=0.0)
//        active_currencies = models.IntegerField(default=0)
//        bitcoin_percent = models.FloatField(default=0.0)
//        last_updated = models.DateTimeField(default=timezone.now)