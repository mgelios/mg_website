import { types } from "./types";

export const actions = Object.freeze({
    fetchCurrentWeather,
    fetchWeatherForecast,
});

async function fetchCurrentWeather({ commit }) {
    const currentWeather = '234';
    commit(types.SET_CURRENT_WEATHER, currentWeather);
}

async function fetchWeatherForecast({ commit }) {
    const weatherForecast = '234234';
    commit(types.SET_WEATHER_FORECAST, weatherForecast);
}