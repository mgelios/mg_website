import { types } from "./types";

export const mutations = {
    [types.SET_PROFILE](state, value) {
        state.profile = value;
    },

    [types.REMOVE_PROFILE](state) {
        state.profile = null;
        state.authToken = null;
    }
};