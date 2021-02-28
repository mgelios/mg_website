import { types } from "./types";
import { currentWeather, weatherForecast } from "../../api/service/weather";

export const actions = Object.freeze({
    fetchCurrentWeather,
    fetchWeatherForecast,
});

async function fetchCurrentWeather({ commit }) {
    const currentWeatherResponse = await currentWeather.get('');
    if (currentWeatherResponse.success) {
        commit(types.SET_CURRENT_WEATHER, currentWeatherResponse.data);
    }
}

async function fetchWeatherForecast({ commit }) {
    const weatherForecastResponse = await weatherForecast.getList();
    if (weatherForecastResponse.success) {
        commit(types.SET_WEATHER_FORECAST, weatherForecastResponse.data);
    }
}