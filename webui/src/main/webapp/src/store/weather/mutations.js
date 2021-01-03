import { types } from "./types";

export const mutations = {
    [types.SET_CURRENT_WEATHER](state, value) {
        state.currentWeather = value;
    },

    [types.SET_WEATHER_FORECAST](state, value) {
        state.weatherForecast = value;
    }
};