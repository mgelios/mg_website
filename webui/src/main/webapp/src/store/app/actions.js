import { types } from "./types";

export const actions = Object.freeze({
    restoreDataFromLocalStorage,
    saveAuthToken,
});

async function restoreDataFromLocalStorage({ commit }, data) {
    commit(types.SAVE_APP_DATA, data);
}

async function saveAuthToken({ commit }, data) {
    commit(types.SAVE_AUTH_TOKEN, data);
}