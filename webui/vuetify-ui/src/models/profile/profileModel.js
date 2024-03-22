export class ProfileModel {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.role
     * @param {String} config.username
     * @param {String} config.firstName
     * @param {String} config.lastName
     * @param {String} config.email
     * @param {Boolean} config.enabled
     *
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.role = config.role;
        this.username = config.username;
        this.email = config.email;
        this.enabled = config.enabled;
        this.firstName = config.firstName;
        this.lastName = config.lastName;
    }
}