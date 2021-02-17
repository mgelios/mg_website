import { types } from "./types";

export const mutations = {
    [types.SAVE_API_CONSUMERS](state, value) {
        state.apiConsumers = value;
    },

    [types.INIT_API_CONSUMER_TO_ADD](state, value) {
        state.apiConsumerToAdd = value;
    }
};