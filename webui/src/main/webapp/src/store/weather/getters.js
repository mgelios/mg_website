export const getters = Object.freeze({
    weatherForecastDaysEntries,
});

function weatherForecastDaysEntries(state) {
    if (state.weatherForecast != null) {
        let setOfDates = new Set();
        state.weatherForecast.forEach(forecastItem => {
            setOfDates.add(forecastItem.time.value.getDate());
        });
        console.log(setOfDates);
    }
}