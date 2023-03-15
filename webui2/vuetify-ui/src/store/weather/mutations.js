import { types } from "./types";
import {GroupedWeatherForecastByDayModel} from "../../models/weather/groupedWeatherForecastByDayModel";

export const mutations = {
    [types.SET_CURRENT_WEATHER](state, value) {
        state.currentWeather = value;
    },

    [types.SET_WEATHER_FORECAST](state, value) {
        state.weatherForecast = value;
        state.weatherForecast.sort((a,b) => {
            return a.time.value - b.time.value;
        });
    },

    [types.SET_GROUPED_WEATHER_FORECAST](state, value) {
        let sortedForecastItems = value;
        sortedForecastItems.sort((a,b) => {
            return a.time.value - b.time.value;
        });

        let groupedWeatherForecastItems = new Map();
        sortedForecastItems.forEach(forecastItem => {
            if (!groupedWeatherForecastItems.get(forecastItem.time.value.getDate())) {
                groupedWeatherForecastItems.set(
                    forecastItem.time.value.getDate(),
                    new GroupedWeatherForecastByDayModel(forecastItem)
                );
            } else {
                groupedWeatherForecastItems.get(forecastItem.time.value.getDate()).rewriteFieldsIfNeeded(forecastItem);
            }
        });
        state.weatherForecastGroupedByDay = groupedWeatherForecastItems;
    }
};