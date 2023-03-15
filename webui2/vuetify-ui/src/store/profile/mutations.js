import { types } from "./types";

export const mutations = {
    [types.SET_ACTIVE_PROFILE](state, value) {
        state.activeProfile = value;
    },

    [types.SET_AUTH_TOKEN](state, value) {
        state.authToken = value;
    },

    [types.REMOVE_ACTIVE_PROFILE](state) {
        state.activeProfile = null;
    },

    [types.REMOVE_AUTH_TOKEN](state) {
        state.authToken = null;
    }
};