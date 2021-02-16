import { apiConsumer } from "../../api/service/apiConsumer";
import { types } from "./types";

export const actions = Object.freeze({
    fetchApiConsumers,
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
