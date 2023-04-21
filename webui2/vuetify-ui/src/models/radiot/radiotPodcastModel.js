import { DateModel } from "../common/dateModel";
import {RadiotPodcastTimeLabelModel} from "./radiotPodcastTimeLabelModel";

export class RadiotPodcastModel {
    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.url
     * @param {String} config.title
     * @param {String} config.image
     * @param {String} config.body
     * @param {String} config.showNotes
     * @param {String} config.audioUrl
     * @param {Number} config.date
     * @param {Number} config.timeLabels
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.url = config.url;
        this.title = config.title;
        this.image = config.image;
        this.body = config.body;
        this.showNotes = config.showNotes;
        this.audioUrl = config.audioUrl;
        this.date = new DateModel(config.date);
        this.timeLabels = config.timeLabels.map(item => new RadiotPodcastTimeLabelModel(item));
    }
}