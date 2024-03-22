export const getters = Object.freeze({
    daysCollection,
    maxTempForecast,
    minTempForecast,
    maxPressureForecast,
    groupedForecastAsList,
});

function groupedForecastAsList(state) {
    let forecastGroupedByDay = state.weatherForecastGroupedByDay;
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values());
    }
    return null;
}

function daysCollection(state) {
    let forecastGroupedByDay = state.weatherForecastGroupedByDay;
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.keys());
    }
    return null;
}

function maxTempForecast(state) {
    let forecastGroupedByDay = state.weatherForecastGroupedByDay;
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values()).map(item => item.maxTemp);
    }
    return null;
}

function minTempForecast(state) {
    let forecastGroupedByDay = state.weatherForecastGroupedByDay;
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values()).map(item => item.minTemp);
    }
    return null;
}

function maxPressureForecast(state) {
    let forecastGroupedByDay = state.weatherForecastGroupedByDay;
    if (forecastGroupedByDay) {
        return Array.from(forecastGroupedByDay.values()).map(item => item.maxPressure);
    }
    return null;
}