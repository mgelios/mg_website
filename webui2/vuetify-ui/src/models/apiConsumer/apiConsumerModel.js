export class ApiConsumerModel {
    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.name
     * @param {String} config.apiKey
     * @param {String} config.token
     * @param {String} config.clientId
     * @param {String} config.clientSecret
     *
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.name = config.name;
        this.apiKey = config.apiKey;
        this.token = config.token;
        this.clientId = config.clientId;
        this.clientSecret = config.clientSecret;
    }
}