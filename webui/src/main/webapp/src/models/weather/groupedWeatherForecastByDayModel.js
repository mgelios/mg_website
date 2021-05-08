export class GroupedWeatherForecastByDayModel {

    /**
     * @param {WeatherForecastItemModel} props
     * @param {DateModel} props.time
     * @param {Number} props.maximumTemperature
     * @param {Number} props.minimalTemperature
     * @param {Number} props.windSpeed
     * @param {Number} props.humidity;
     * @param {Number} props.pressure;
     */
    constructor(props) {
        props = props || {};
        this.date = props.time;
        this.maxTemp = props.maximumTemperature;
        this.minTemp = props.minimalTemperature;
        this.maxWindSpeed = props.windSpeed;
        this.maxHumidity = props.humidity;
        this.maxPressure = props.pressure;
    }

    rewriteItemsIfNeeded(forecastItem) {
        if (forecastItem.maximumTemperature > this.maxTemp) {
            this.maxTemp = forecastItem.maximumTemperature;
        }
        if (forecastItem.minimalTemperature < this.minTemp) {
            this.minTemp = forecastItem.minimalTemperature;
        }
        if (forecastItem.windSpeed > this.maxWindSpeed) {
            this.maxWindSpeed = forecastItem.windSpeed;
        }
        if (forecastItem.humidity > this.maxHumidity) {
            this.maxHumidity = forecastItem.humidity;
        }
        if (forecastItem.pressure > this.maxPressure) {
            this.maxPressure = forecastItem.pressure;
        }
    }
}