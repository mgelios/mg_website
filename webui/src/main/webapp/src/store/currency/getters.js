export const getters = Object.freeze({
    statisticsUsd,
    statisticsEur,
});

function statisticsUsd(state) {
    return state.get('USD');
}

function statisticsEur(state) {
    return state.get('EUR');
}