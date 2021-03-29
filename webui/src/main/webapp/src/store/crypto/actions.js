import { types } from './types';

export const actions = Object.freeze({
    fetchCurrencies,
    fetchMarketInfo,
});

async function fetchCurrencies({ commit }) {
    const currenciesResponse = await smth;
    if (currenciesResponse.success) {
        commit(types.SET_CRYPTO_CURRENCIES, currenciesResponse.data);
    }
}

async function fetchMarketInfo({ commit }) {
    const marketResponse = await smth;
    if (marketResponse.success) {
        commit(types.SET_CRYPTO_MARKET, marketResponse.data);
    }
}