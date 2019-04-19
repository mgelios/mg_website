import crypto from '../../api/crypto';

const state = {
    all: ["sdfsdf"]
}

const getters = {
}

const actions = {
    getAllCryptoCurrencies({ commit }) {
        crypto.getCryptoCurrencies(currencies => {
            commit('setCryptoCurrencies', currencies);
        })
    }
}

const mutations = {
    setCryptoCurrencies(state, items) {
        state.all = items
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}

