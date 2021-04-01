import { types } from './types';
import { cryptoCurrency } from "../../api/service/crypto";
import { cryptoCurrencyMarket } from "../../api/service/crypto";

export const actions = Object.freeze({
    fetchCurrencies,
    fetchMarketInfo,
});

async function fetchCurrencies({ commit }) {
    const currenciesResponse = await cryptoCurrency.getList();
    if (currenciesResponse.success) {
        commit(types.SET_CRYPTO_CURRENCIES, currenciesResponse.data);
    }
}

async function fetchMarketInfo({ commit }) {
    const marketResponse = await cryptoCurrencyMarket.get('');
    if (marketResponse.success) {
        commit(types.SET_CRYPTO_MARKET, marketResponse.data);
    }
}