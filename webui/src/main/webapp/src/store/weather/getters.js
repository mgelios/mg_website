import {GroupedWeatherForecastByDayModel} from "../../models/weather/groupedWeatherForecastByDayModel";

export const getters = Object.freeze({
    weatherForecastDaysEntries,
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
        console.log(groupedWeatherForecastItems);
        console.log(Array.from(groupedWeatherForecastItems.keys()));
        console.log(Array.from(groupedWeatherForecastItems.values()).map(item => {
            return item.maxTemp;
        }));
        console.log(Array.from(groupedWeatherForecastItems.values()).map(item => {
            return item.minTemp;
        }));
        return groupedWeatherForecastItems;
    }
    return null;
}