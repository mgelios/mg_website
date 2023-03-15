import { types } from "./types";

export const mutations = Object.freeze({
    [types.SET_CRYPTO_CURRENCIES](state, values) {
        state.currencies = values;
    },
    [types.SET_CRYPTO_MARKET](state, value) {
        state.market = value;
    }
});