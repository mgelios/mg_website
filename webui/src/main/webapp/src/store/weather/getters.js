import {GroupedWeatherForecastByDayModel} from "../../models/weather/groupedWeatherForecastByDayModel";

export const getters = Object.freeze({
    daysCollection,
    weatherForecastGroupedByDay,
    maxTempForecast,
    minTempForecast,
    maxPressureForecast,
    groupedForecastAsList,
});

function weatherForecastGroupedByDay(state) {
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
        console.log(groupedWeatherForecastItems);
        return groupedWeatherForecastItems;
    }
    return null;
}

function groupedForecastAsList(state) {
    let forecastGroupedByDay = weatherForecastGroupedByDay(state);
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values());
    }
    return null;
}

function daysCollection(state) {
    let forecastGroupedByDay = weatherForecastGroupedByDay(state);
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.keys());
    }
    return null;
}

function maxTempForecast(state) {
    let forecastGroupedByDay = weatherForecastGroupedByDay(state);
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values()).map(item => item.maxTemp);
    }
    return null;
}

function minTempForecast(state) {
    let forecastGroupedByDay = weatherForecastGroupedByDay(state);
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values()).map(item => item.minTemp);
    }
    return null;
}

function maxPressureForecast(state) {
    let forecastGroupedByDay = weatherForecastGroupedByDay(state);
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values()).map(item => item.maxPressure);
    }
    return null;
}