export class DateModel {
    /**
     * @param {Number} value
     */
    constructor(value) {
        this.value = new Date(value * 1000);
    }
}