import { types } from "./types";

export const actions = Object.freeze({
    fetchCurrentWeather
});

async function fetchCurrentWeather({ commit }) {
    const currentWeather = await smth;
    commit(types.SET_CURRENT_WEATHER, currentWeather);
}