import { state } from "./state";
import { actions } from "./actions";
import { getters } from "./getters";
import { mutations } from "./mutations";

export const weather = {
    namespaced: true,

    state,
    actions,
    getters,
    mutations,
};
