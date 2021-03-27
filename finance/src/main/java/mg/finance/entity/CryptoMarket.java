package mg.finance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name="mg_crypto_currency_market")
public class CryptoMarket {

    @Id
    @GeneratedValue
    private UUID uuid;
    private Long activeCryptoCurrencies;
    private Long totalCryptoCurrencies;
    private Long btcDominance;
    private Long ethDominance;
    private Long totalMarketCapUsd;
    private Long totalDayVolumeUsd;
    private Long altcoinMarketCapUsd;
    private Long altcoinDayVolumeUsd;
    private OffsetDateTime lastUpdated;
}

//    "data": {
//        "active_cryptocurrencies": 4479,
//        "total_cryptocurrencies": 8936,
//        "active_market_pairs": 37007,
//        "active_exchanges": 370,
//        "total_exchanges": 1311,
//        "eth_dominance": 11.284637044336,
//        "btc_dominance": 59.789424403697,
//        "defi_volume_24h": 11443318700.846958,
//        "defi_volume_24h_reported": 11443318700.846958,
//        "defi_market_cap": 86212914553.46652,
//        "defi_24h_percentage_change": -3.950459396649,
//        "stablecoin_volume_24h": 92827590930.00217,
//        "stablecoin_volume_24h_reported": 92827590930.00217,
//        "stablecoin_market_cap": 68506356538.48167,
//        "stablecoin_24h_percentage_change": -11.589817465437,
//        "derivatives_volume_24h": 121400042000.9815,
//        "derivatives_volume_24h_reported": 121400042000.9815,
//        "derivatives_24h_percentage_change": -21.382419909975,
//        "quote": {
//            "USD": {
//                "total_market_cap": 1737050605779.906,
//                "total_volume_24h": 125956680675.98,
//                "total_volume_24h_reported": 125956680675.98,
//                "altcoin_volume_24h": 70830540817.20326,
//                "altcoin_volume_24h_reported": 70830540817.20326,
//                "altcoin_market_cap": 698478046983.1655,
//                "last_updated": "2021-03-24T08:00:17.999Z"
//            }
//        },
//        "last_updated": "2021-03-24T08:00:17.999Z"
//    }
//}