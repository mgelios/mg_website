export const getters = Object.freeze({
    weatherForecastDaysEntries,
});

function weatherForecastDaysEntries(state) {
    if (state.weatherForecast != null) {
        console.log(state.weatherForecast[0].time.value.getDate());
    }
}