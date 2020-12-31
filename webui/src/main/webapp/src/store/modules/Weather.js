import weather from '../../api/service/weather';

const state = {
    currentWeather: {},
    weatherForecast: []
};

const getters = {
};

const actions = {
    getCurrentWeather(context) {
        weather.getCurrentWeather(data => {
            context.commit('setCurrentWeather', data);
        })
    },
    getWeatherForecast(context) {
        weather.getWeatherForecast(data => {
            context.commit('setWeatherForecast', data);
        })
    }
};

const mutations = {
    setCurrentWeather(state, data) {
        state.currentWeather = data;
    },
    setWeatherForecast(state, data) {
        state.weatherForecast = data;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}