import { types } from './types';
import { currency, currencyStatistics, currencyConversion } from "../../api/service/currency";

export const actions = Object.freeze({
    fetchExchangeRates,
    fetchCurrencyConversions,
    fetchCurrencyStatistics,
});

async function fetchExchangeRates({ commit }) {
    const exchangeRatesResponse = await currency.getList();
    if (exchangeRatesResponse.success) {
        commit(types.SET_EXCHANGE_RATES, exchangeRatesResponse.data);
    }
}

async function fetchCurrencyConversions({ commit }) {
    const currencyConversionsResponse = await currencyConversion.getList();
    if (currencyConversionsResponse.success) {
        commit(types.SET_CURRENCY_CONVERSIONS, currencyConversionsResponse.data);
    }
}

async function fetchCurrencyStatistics({ commit }) {
    const currencyStatisticsResponse = await currencyStatistics.getMap();
    if (currencyStatisticsResponse.success) {
        commit(types.SET_ANNUAL_CURRENCY_STATISTICS_EUR, currencyStatisticsResponse.data.get('EUR'));
        commit(types.SET_ANNUAL_CURRENCY_STATISTICS_USD, currencyStatisticsResponse.data.get('USD'));
        commit(types.SET_MONTHLY_CURRENCY_STATISTICS_EUR, currencyStatisticsResponse.data.get('EUR'));
        commit(types.SET_MONTHLY_CURRENCY_STATISTICS_USD, currencyStatisticsResponse.data.get('USD'));
    }
}