import {types} from "./types";

export const mutations = {
    [types.SET_PODCASTS](state, values) {
        state.podcasts = values;
    }
};