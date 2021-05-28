import { types } from "./types";

export const mutations = Object.freeze({
    [types.SET_EXCHANGE_RATES](state, values) {
        state.currencyRates = values;
    },
    [types.SET_CURRENCY_CONVERSIONS](state, values) {
        state.currencyConversions = values;
    },
    [types.SET_CURRENCY_STATISTICS_EUR](state, values) {
        state.currencyStatisticsEur = values;
        state.currencyStatisticsEur.sort((a, b) => {
            return a.date.value - b.date.value;
        });
    },
    [types.SET_CURRENCY_STATISTICS_USD](state, values) {
        state.currencyStatisticsUsd = values;
        state.currencyStatisticsUsd.sort((a, b) => {
            return a.date.value - b.date.value;
        });
    }
});