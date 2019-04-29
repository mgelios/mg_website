import crypto from '../../api/crypto';

const state = {
    all: [],
    market: {}
};

const getters = {
};

const actions = {
    getAllCryptoCurrencies({ commit }) {
        crypto.getCryptoCurrencies(currencies => {
            commit('setCryptoCurrencies', currencies);
        })
    },
    getCryptoMarket({ commit }) {
        crypto.getCryptoMarket(market => {
            commit('setCryptoMarket', market);
        })
    }
};

const mutations = {
    setCryptoCurrencies(state, items) {
        state.all = items
    },
    setCryptoMarket(state, data) {
        state.market = data;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}

