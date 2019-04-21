import weather from '../../api/weather';

const state = {
    currentWeather: {},
    weatherForecast: []
}

const getters = {
}

const actions = {
    getCurrentWeather({ commit }) {
        weather.getCurrentWeather(data => {
            commit('setCurrentWeather', data);
        })
    },
    getWeatherForecast({ commit }) {
        weather.getWeatherForecast(data => {
            commit('setWeatherForecast', data);
        })
    }
}

const mutations = {
    setCurrentWeather(state, data) {
        state.currentWeather = data;
    },
    setWeatherForecast(state, data) {
        state.weatherForecast = data;
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}