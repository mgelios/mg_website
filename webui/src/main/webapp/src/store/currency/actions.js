import { types } from './types';

export const actions = Object.freeze({
    fetchExchangeRates,
    fetchCurrencyConversions,
    fetchCurrencyStatistics,
});

async function fetchExchangeRates({ commit }) {
    const exchangeRates = null;
    commit(types.SET_EXCHANGE_RATES, exchangeRates);
}

async function fetchCurrencyConversions({ commit }) {
    const currencyConversions = null;
    commit(types.SET_CURRENCY_STATISTICS, currencyConversions);
}

async function fetchCurrencyStatistics({ commit }) {
    const currencyStatistics = null;
    commit(types.SET_CURRENCY_STATISTICS, currencyStatistics);
}