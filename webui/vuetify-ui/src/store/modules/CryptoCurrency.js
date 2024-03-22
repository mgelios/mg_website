import cryptoApiService from '../../api/service/cryptoApiService';

const state = {
    all: [],
    market: {}
};

const getters = {
};

const actions = {
    getAllCryptoCurrencies(context) {
        cryptoApiService.getCryptoCurrencies(currencies => {
            context.commit('setCryptoCurrencies', currencies);
        })
    },
    getCryptoMarket(context) {
        cryptoApiService.getCryptoMarket(market => {
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

