import { types } from "./types";

export const mutations = Object.freeze({
    [types.SET_EXCHANGE_RATES](state, values) {
        state.currencyRates = values;
    },
    [types.SET_CURRENCY_CONVERSIONS](state, values) {
        state.currencyConversions = values;
    },
    [types.SET_CURRENCY_STATISTICS](state, values) {
        state.monthStatisticsEUR = values;
        state.monthStatisticsUSD = values;
    }
});