import { actions } from "./actions";
import { state } from "./state";
import { getters } from "./getters";
import { mutations } from "./mutations";

export const apiConsumer = {
    namespaced: true,

    state,
    actions,
    getters,
    mutations,
}