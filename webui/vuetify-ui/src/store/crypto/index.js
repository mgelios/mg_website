import { state } from "./state";
import { actions } from "./actions";
import { getters } from "./getters";
import { mutations } from "./mutations";

export const crypto = {
    namespaced: true,

    state,
    actions,
    getters,
    mutations
};