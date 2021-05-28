export const getters = Object.freeze({
    statisticsUsd,
    statisticsEur,
});

function statisticsUsd(state) {
    return state.currencyStatisticsUsd;
}

function statisticsEur(state) {
    return state.currencyStatisticsEur;
}