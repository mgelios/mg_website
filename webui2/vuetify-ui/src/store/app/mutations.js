import {types} from "./types";

export const mutations = {
    [types.SAVE_APP_DATA](state, value) {
        state.appData = value;
        localStorage.setItem('appData', JSON.stringify(state.appData));
    },

    [types.SAVE_AUTH_TOKEN](state, value) {
        if (state.appData == null) {
            state.appData = {};
        }
        state.appData.authToken = value;
        localStorage.setItem('appData', JSON.stringify(state.appData));
    },

    [types.REMOVE_APP_DATA](state) {
        state.appData = null;
        localStorage.removeItem('appData');
    }
};