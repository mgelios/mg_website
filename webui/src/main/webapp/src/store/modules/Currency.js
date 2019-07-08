import currency from '../../api/currency';

const state = {
    rates: [],
    conversions: [],
    statisticsEUR: [],
    statisticsUSD: []
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
    },
    getCurrenciesStatistics({ commit }) {
        currency.getStatistics(statistics => {
            commit('setCurrenciesStatistics', statistics);
        })
    }
};

const mutations = {
    setExchangeRates(state, items) {
        state.rates = items;
    },
    setCurrencyConversions(state, items) {
        state.conversions = items;
    },
    setCurrenciesStatistics(state, items) {
        state.statisticsEUR = items.EUR;
        state.statisticsUSD = items.USD;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}
