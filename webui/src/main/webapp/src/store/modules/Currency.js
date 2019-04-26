import currency from '../../api/currency';

const state = {
    rates: [],
    conversions: []
};

const getters = {
};

const actions = {
    getExchangeRates({ commit }) {
        currency.getExchangeRates(currencies => {
            commit('setExchangeRates', currencies);
        })
    },
    getCurrencyConversions({ commit }) {
        currency.getConversions(conversions => {
            commit('setCurrencyConversions', conversions);
        })
    }
};

const mutations = {
    setExchangeRates(state, items) {
        state.rates = items;
    },
    setCurrencyConversions(state, items) {
        state.conversions = items;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}
