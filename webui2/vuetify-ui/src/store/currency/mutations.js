import { types } from "./types";

export const mutations = Object.freeze({
    [types.SET_EXCHANGE_RATES](state, values) {
        state.currencyRates = values;
    },
    [types.SET_CURRENCY_CONVERSIONS](state, values) {
        state.currencyConversions = values;
    },
    [types.SET_ANNUAL_CURRENCY_STATISTICS_EUR](state, values) {
        state.annualCurrencyStatisticsEur = values;
        state.annualCurrencyStatisticsEur.sort((a, b) => {
            return a.date.value - b.date.value;
        });
    },
    [types.SET_ANNUAL_CURRENCY_STATISTICS_USD](state, values) {
        state.annualCurrencyStatisticsUsd = values;
        state.annualCurrencyStatisticsUsd.sort((a, b) => {
            return a.date.value - b.date.value;
        });
    },
    [types.SET_MONTHLY_CURRENCY_STATISTICS_EUR](state, values) {
        state.monthlyCurrencyStatisticsEur = values;
        state.monthlyCurrencyStatisticsEur.sort((a, b) => {
            return a.date.value - b.date.value;
        });
        state.monthlyCurrencyStatisticsEur = state.monthlyCurrencyStatisticsEur
            .slice(state.monthlyCurrencyStatisticsEur.length - 31, state.monthlyCurrencyStatisticsEur.length);
    },
    [types.SET_MONTHLY_CURRENCY_STATISTICS_USD](state, values) {
        state.monthlyCurrencyStatisticsUsd = values;
        state.monthlyCurrencyStatisticsUsd.sort((a, b) => {
            return a.date.value - b.date.value;
        });
        state.monthlyCurrencyStatisticsUsd = state.monthlyCurrencyStatisticsUsd
            .slice(state.monthlyCurrencyStatisticsUsd.length - 31, state.monthlyCurrencyStatisticsUsd.length);
    }
});