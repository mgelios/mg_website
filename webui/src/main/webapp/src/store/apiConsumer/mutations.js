import { types } from "./types";

export const mutations = {
    [types.SAVE_API_CONSUMERS](state, value) {
        state.apiConsumers = value;
    },
};