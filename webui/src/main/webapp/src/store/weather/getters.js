import {GroupedWeatherForecastByDayModel} from "../../models/weather/groupedWeatherForecastByDayModel";

export const getters = Object.freeze({
    weatherForecastDaysEntries,
    maxTempForecast,
    minTempForecast
});

function weatherForecastDaysEntries(state) {
    if (state.weatherForecast != null) {
        let groupedWeatherForecastItems = new Map();
        state.weatherForecast.forEach(forecastItem => {
            if (!groupedWeatherForecastItems.get(forecastItem.time.value.getDate())) {
                groupedWeatherForecastItems.set(
                    forecastItem.time.value.getDate(),
                    new GroupedWeatherForecastByDayModel(forecastItem)
                );
            } else {
                groupedWeatherForecastItems.get(forecastItem.time.value.getDate()).rewriteItemsIfNeeded(forecastItem);
            }
        });
        return groupedWeatherForecastItems;
    }
    return null;
}

function maxTempForecast() {
    let result = new Array();
    return result;
}

function minTempForecast() {
    let result = new Array();
    return result;
}