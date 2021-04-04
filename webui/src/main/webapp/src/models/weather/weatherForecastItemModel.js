export class WeatherForecastItemModel {

    /**
     * @param {Object} config
     * @param {String} config.uuid
     * @param {String} config.mainInfo
     * @param {String} config.description
     * @param {String} config.icon
     * @param {String} config.cityName
     * @param {Number} config.temperature
     * @param {Number} config.feelsLike
     * @param {Number} config.minimalTemperature
     * @param {Number} config.maximumTemperature
     * @param {Number} config.pressure
     * @param {Number} config.seaLevel
     * @param {Number} config.groundLevel
     * @param {Number} config.humidity
     * @param {Number} config.windSpeed
     * @param {Number} config.windDegree
     * @param {String} config.time
     * @param {String} config.updateTime
     *
     */
    constructor(config) {
        config = config || {};
        this.uuid = config.uuid;
        this.mainInfo = config.mainInfo;
        this.description = config.description;
        this.icon = config.icon;
        this.cityName = config.cityName;
        this.temperature = config.temperature;
        this.feelsLike = config.feelsLike;
        this.minimalTemperature = config.minimalTemperature;
        this.maximumTemperature = config.maximumTemperature;
        this.pressure = config.pressure;
        this.seaLevel = config.seaLevel;
        this.groundLevel = config.groundLevel;
        this.humidity = config.humidity;
        this.windSpeed = config.windSpeed;
        this.windDegree = config.windDegree;
        this.time = config.time;
        this.updateTime = config.updateTime;
    }
}