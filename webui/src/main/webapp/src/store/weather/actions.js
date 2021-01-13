import { types } from "./types";

export const actions = Object.freeze({
    fetchCurrentWeather,
    fetchWeatherForecast,
});

async function fetchCurrentWeather({ commit }) {
    const currentWeather = await smth;
    commit(types.SET_CURRENT_WEATHER, currentWeather);
}

async function fetchWeatherForecast({ commit }) {
    const weatherForecast = await smth;
    commit(types.SET_WEATHER_FORECAST, weatherForecast);
}