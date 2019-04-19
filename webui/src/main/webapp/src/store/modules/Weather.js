import weather from '../../api/weather';

const state = {
    currentWeather: {}
}

const getters = {
}

const actions = {
    getCurrentWeather({ commit }) {
        weather.getCurrentWeather(data => {
            commit('setCurrentWeather', data);
        })
    }
}

const mutations = {
    setCurrentWeather(state, data) {
        state.currentWeather = data;
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}