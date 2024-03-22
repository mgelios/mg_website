import { DateModel } from "../common/dateModel";

export class RadiotArticleModel {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.title
     * @param {String} config.content
     * @param {String} config.snippet
     * @param {String} config.mainPicture
     * @param {String} config.link
     * @param {String} config.author
     * @param {String} config.feed
     * @param {String} config.slug
     * @param {Number} config.comments
     * @param {Number} config.likes
     * @param {Object} config.originalTime
     * @param {Object} config.radiotTime
     * @param {Object} config.lastUpdated
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.title = config.title;
        this.content = config.content;
        this.snippet = config.snippet;
        this.mainPicture = config.mainPicture;
        this.link = config.link;
        this.author = config.author;
        this.feed = config.feed;
        this.slug = config.slug;
        this.comments = config.comments;
        this.likes = config.likes;
        this.originalTime = new DateModel(config.originalTime);
        this.radiotTime = new DateModel(config.radiotTime);
        this.lastUpdated = new DateModel(config.lastUpdated);
    }
}