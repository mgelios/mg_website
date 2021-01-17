export class Currency {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.date
     * @param {String} config.abbreviation
     * @param {String} config.name
     * @param {Number} config.systemId
     * @param {Number} config.scale
     * @param {Number} config.rate
     *
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.date = config.date;
        this.abbreviation = config.abbreviation;
        this.name = config.name;
        this.systemId = config.systemId;
        this.scale = config.scale;
        this.rate = config.rate;
    }
}