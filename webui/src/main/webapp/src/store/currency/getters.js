export const getters = Object.freeze({
    statisticsUsd,
    statisticsEur,
});

function statisticsUsd(state) {
    return state.currencyStatistics.get('USD');
}

function statisticsEur(state) {
    return state.currencyStatistics.get('EUR');
}