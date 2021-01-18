import {CurrencyModel} from "./currencyModel";

export class CurrencyConversionModel {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {Object} config.currencyFrom
     * @param {Object} config.currencyTo
     * @param {Number} config.value
     *
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.currencyFrom = config.currencyFrom ? new CurrencyModel(config.currencyFrom) : null;
        this.currencyTo = config.currencyTo ? new CurrencyModel(config.currencyTo) : null;
        this.value = config.value;
    }
}