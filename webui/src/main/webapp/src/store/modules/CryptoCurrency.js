import crypto from '../../api/crypto';

const state = {
    all: [],
    market: {}
};

const getters = {
};

const actions = {
    getAllCryptoCurrencies(context) {
        crypto.getCryptoCurrencies(currencies => {
            context.commit('setCryptoCurrencies', currencies);
        })
    },
    getCryptoMarket(context) {
        crypto.getCryptoMarket(market => {
            context.commit('setCryptoMarket', market);
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

