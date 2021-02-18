import { apiConsumer } from "../../api/service/apiConsumer";
import { types } from "./types";
import { ApiConsumerModel } from "../../models/apiConsumer/apiConsumerModel";
import { router } from "../../utils/router/router";

export const actions = Object.freeze({
    fetchApiConsumers,
    initApiConsumerToAdd,
    saveApiConsumer,
});

async function fetchApiConsumers({ commit, rootState }) {
    const response = await apiConsumer.getList({
        headers: {
            Authorization: rootState.profile.authToken,
        }
    });
    if (response.success) {
        commit(types.SAVE_API_CONSUMERS, response.data);
    }
}

async function saveApiConsumer({ state, rootState }) {
    const response = await apiConsumer.post(state.apiConsumerToAdd,{
        headers: {
            Authorization: rootState.profile.authToken,
        }
    });
    if (response.success) {
        router.push({ name: 'admin' });
    }
}

async function initApiConsumerToAdd({ commit }) {
    commit(types.INIT_API_CONSUMER_TO_ADD, new ApiConsumerModel({}));
}