package mg.finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name="mg_crypto_currency")
public class CryptoCurrency {

//    @Id
//    @GeneratedValue
    private UUID uuid;
    private String name;
    private String symbol;
    private long rank;
    private double availableSupply;
    private double totalSupply;
    private double maxSupply;
    private double priceUsd;
    private double volumeLastDayUsd;
    private double marketCapUsd;
    private double percentChangeLastHour;
    private double percentChangeLastDay;
    private double percentChangeLastWeek;
    private double percentChangeLastMonth;
    private double percentChangeLastThreeMonth;
    private OffsetDateTime lastUpdated;
}

//    "data": [
//        {
//            "id": 1,
//            "name": "Bitcoin",
//            "symbol": "BTC",
//            "slug": "bitcoin",
//            "num_market_pairs": 9618,
//            "cmc_rank": 1,
//            "date_added": "2013-04-28T00:00:00.000Z",
//            "max_supply": 21000000,
//            "circulating_supply": 18662906,
//            "total_supply": 18662906,
//            "platform": null,
//            "last_updated": "2021-03-24T08:17:02.000Z",
//            "quote": {
//                "USD": {
//                    "price": 56198.94095760309,
//                    "volume_24h": 55855668248.37931,
//                    "percent_change_1h": 3.94823022,
//                    "percent_change_24h": 4.451077,
//                    "percent_change_7d": -0.163177,
//                    "percent_change_30d": 0.28434205,
//                    "percent_change_60d": 70.62670893,
//                    "percent_change_90d": 143.67067171,
//                    "market_cap": 1048835552391.2964,
//                    "last_updated": "2021-03-24T08:17:02.000Z"
//                }
//            }
//            "tags": [
//                "mineable",
//                "pow",
//                "sha-256",
//                "store-of-value",
//                "state-channels",
//                "coinbase-ventures-portfolio",
//                "three-arrows-capital-portfolio",
//                "polychain-capital-portfolio"
//            ],

//        },
//        {
//            "id": 1027,
//            "name": "Ethereum",
//            "symbol": "ETH",
//            "slug": "ethereum",
//            "num_market_pairs": 6112,
//            "date_added": "2015-08-07T00:00:00.000Z",
//            "tags": [
//                "mineable",
//                "pow",
//                "smart-contracts",
//                "ethereum",
//                "coinbase-ventures-portfolio",
//                "three-arrows-capital-portfolio",
//                "polychain-capital-portfolio"
//            ],
//            "max_supply": null,
//            "circulating_supply": 115178918.374,
//            "total_supply": 115178918.374,
//            "platform": {
//                "id": 2502,
//                "name": "Heco",
//                "symbol": "HT",
//                "slug": "huobi-token",
//                "token_address": "0x64ff637fb478863b7468bc97d30a5bf3a428a1fd"
//            },
//            "cmc_rank": 2,
//            "last_updated": "2021-03-24T08:17:02.000Z",
//            "quote": {
//                "USD": {
//                    "price": 1714.9896818816699,
//                    "volume_24h": 20282095083.383583,
//                    "percent_change_1h": 2.60063286,
//                    "percent_change_24h": 2.49325306,
//                    "percent_change_7d": -4.04760405,
//                    "percent_change_30d": -8.5141121,
//                    "percent_change_60d": 36.56551447,
//                    "percent_change_90d": 196.95901856,
//                    "market_cap": 197530656581.70108,
//                    "last_updated": "2021-03-24T08:17:02.000Z"
//                }
//            }
//        },