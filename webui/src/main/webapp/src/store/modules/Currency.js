import currency from '../../api/service/currency';

const state = {
    rates: [],
    conversions: [],
    statisticsEUR: [],
    statisticsUSD: []
};

const getters = {
};

const actions = {
    getExchangeRates(context) {
        currency.getExchangeRates(currencies => {
            context.commit('setExchangeRates', currencies);
        })
    },
    getCurrencyConversions(context) {
        currency.getConversions(conversions => {
            context.commit('setCurrencyConversions', conversions);
        })
    },
    getCurrenciesStatistics(context) {
        currency.getStatistics(statistics => {
            context.commit('setCurrenciesStatistics', statistics);
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
