export class CryptoCurrencyModel {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.name
     * @param {Number} config.rank
     * @param {Number} config.availableSupply
     * @param {Number} config.totalSupply
     * @param {Number} config.maxSupply
     * @param {Number} config.priceUsd
     * @param {Number} config.volumeLastDayUsd
     * @param {Number} config.marketCapUsd
     * @param {Number} config.percentChangeLastHour
     * @param {Number} config.percentChangeLastDay
     * @param {Number} config.percentChangeLastWeek
     * @param {Number} config.percentChangeLastMonth
     * @param {Number} config.percentChangeLastThreeMonth
     * @param {Number} config.lastUpdated
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.name = config.name;
        this.rank = config.rank;
        this.availableSupply = config.availableSupply;
        this.totalSupply = config.totalSupply;
        this.maxSupply = config.maxSupply;
        this.priceUsd = config.priceUsd;
        this.volumeLastDayUsd = config.volumeLastDayUsd;
        this.marketCapUsd = config.marketCapUsd;
        this.percentChangeLastHour = config.percentChangeLastHour;
        this.percentChangeLastDay = config.percentChangeLastDay;
        this.percentChangeLastWeek = config.percentChangeLastWeek;
        this.percentChangeLastMonth = config.percentChangeLastMonth;
        this.percentChangeLastThreeMonth = config.percentChangeLastThreeMonth;
        this.lastUpdated = config.lastUpdated;
    }
}

//    private UUID uuid;
//     private String name;
//     private String symbol;
//     private long rank;
//     private double availableSupply;
//     private double totalSupply;
//     private double maxSupply;
//     private double priceUsd;
//     private double volumeLastDayUsd;
//     private double marketCapUsd;
//     private double percentChangeLastHour;
//     private double percentChangeLastDay;
//     private double percentChangeLastWeek;
//     private double percentChangeLastMonth;
//     private double percentChangeLastThreeMonth;
//     private OffsetDateTime lastUpdated;