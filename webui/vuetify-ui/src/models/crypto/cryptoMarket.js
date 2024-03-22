export class CryptoMarket {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {Number} config.activeCryptoCurrencies
     * @param {Number} config.totalCryptoCurrencies
     * @param {Number} config.btcDominance
     * @param {Number} config.ethDominance
     * @param {Number} config.totalMarketCapUsd
     * @param {Number} config.totalDayVolumeUsd
     * @param {Number} config.altcoinMarketCapUsd
     * @param {Number} config.altcoinDayVolumeUsd
     * @param {Number} config.lastUpdated
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.activeCryptoCurrencies = config.activeCryptoCurrencies;
        this.totalCryptoCurrencies = config.totalCryptoCurrencies;
        this.btcDominance = config.btcDominance;
        this.ethDominance = config.ethDominance;
        this.totalMarketCapUsd = config.totalMarketCapUsd;
        this.totalDayVolumeUsd = config.totalDayVolumeUsd;
        this.altcoinMarketCapUsd = config.altcoinMarketCapUsd;
        this.altcoinDayVolumeUsd = config.altcoinDayVolumeUsd;
        this.lastUpdated = config.lastUpdated;
    }
}

//    private UUID uuid;
//     private Long activeCryptoCurrencies;
//     private Long totalCryptoCurrencies;
//     private Long btcDominance;
//     private Long ethDominance;
//     private Long totalMarketCapUsd;
//     private Long totalDayVolumeUsd;
//     private Long altcoinMarketCapUsd;
//     private Long altcoinDayVolumeUsd;
//     private OffsetDateTime lastUpdated;