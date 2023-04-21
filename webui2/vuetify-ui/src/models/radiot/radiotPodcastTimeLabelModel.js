import { DateModel } from "../common/dateModel";

export class RadiotPodcastTimeLabelModel {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.topic
     * @param {Number} config.duration
     * @param {Object} config.time
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.topic = config.topic;
        this.duration = config.duration;
        this.time = new DateModel(config.time);
    }
}