import {CurrencyModel} from "./currencyModel";

export class CurrencyStatisticsItemModel {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {Number} config.currencyId
     * @param {String} config.date
     * @param {Object} config.currency
     * @param {Number} config.rate
     *
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.currencyId = config.currencyId;
        this.date = config.date;
        this.currency = config.currency ? new CurrencyModel(config.currency) : null;
        this.rate = config.rate;
    }
}