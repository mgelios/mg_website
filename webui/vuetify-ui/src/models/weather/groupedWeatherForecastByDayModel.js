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
        this.maxFeelsLike = props.feelsLike;
        this.minFeelsLike = props.feelsLike;
        this.maxWindSpeed = props.windSpeed;
        this.minWindSpeed = props.windSpeed;
        this.maxHumidity = props.humidity;
        this.minHumidity = props.humidity;
        this.maxPressure = props.pressure;
        this.minPressure = props.pressure;
        this.descriptions = new Set();
        this.descriptions.add(props.description);
    }

    rewriteFieldsIfNeeded(forecastItem) {
        this.processTemperature(forecastItem);
        this.processPressure(forecastItem.pressure);
        this.processHumidity(forecastItem.humidity);
        this.processWindSpeed(forecastItem.windSpeed);
        this.descriptions.add(forecastItem.description)
    }

    processTemperature(forecastItem) {
        if (forecastItem.maximumTemperature > this.maxTemp) {
            this.maxTemp = forecastItem.maximumTemperature;
        }
        if (forecastItem.minimalTemperature < this.minTemp) {
            this.minTemp = forecastItem.minimalTemperature;
        }
        if (forecastItem.feelsLike > this.maxFeelsLike) {
            this.maxFeelsLike = forecastItem.feelsLike;
        } else if (forecastItem.feelsLike < this.minFeelsLike) {
            this.minFeelsLike = forecastItem.feelsLike;
        }
    }

    processPressure(pressure) {
        if (pressure > this.maxPressure) {
            this.maxPressure = pressure;
        } else if (pressure < this.minPressure) {
            this.minPressure = pressure;
        }
    }

    processHumidity(humidity) {
        if (humidity > this.maxHumidity) {
            this.maxHumidity = humidity;
        } else if (humidity < this.minHumidity) {
            this.minHumidity = humidity;
        }
    }

    processWindSpeed(windSpeed) {
        if (windSpeed > this.maxWindSpeed) {
            this.maxWindSpeed = windSpeed;
        } else if (windSpeed < this.minWindSpeed) {
            this.minWindSpeed = windSpeed;
        }
    }
}