import { DateModel } from "../common/dateModel";

export class CurrentWeatherModel {

    /**
     * Current Weather config
     *
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.cityName
     * @param {String} config.mainInfo
     * @param {String} config.description
     * @param {String} config.icon
     * @param {Number} config.longitude
     * @param {Number} config.latitude
     * @param {Number} config.temperature
     * @param {Number} config.feelsLike
     * @param {Number} config.pressure
     * @param {Number} config.humidity
     * @param {Number} config.minimalTemperature
     * @param {Number} config.maximumTemperature
     * @param {Number} config.visibility
     * @param {Number} config.windSpeed
     * @param {Number} config.windDegree
     * @param {Number} config.uvi
     * @param {String} config.time
     * @param {String} config.sunrise
     * @param {String} config.sunset
     *
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.cityName = config.cityName;
        this.mainInfo = config.mainInfo;
        this.description = config.description;
        this.icon = config.icon;
        this.longitude = config.longitude;
        this.latitude = config.latitude;
        this.temperature = config.temperature;
        this.feelsLike = config.feelsLike;
        this.pressure = config.pressure;
        this.humidity = config.humidity;
        this.minimalTemperature = config.minimalTemperature;
        this.maximumTemperature = config.maximumTemperature;
        this.visibility = config.visibility;
        this.windSpeed = config.windSpeed;
        this.windDegree = config.windDegree;
        this.uvi = config.uvi;
        this.time = config.time;
        this.sunrise = new DateModel(config.sunrise);
        this.sunset = new DateModel(config.sunset);
    }
}