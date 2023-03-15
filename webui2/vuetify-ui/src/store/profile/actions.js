import { types } from './types';
import { login, profile } from '../../api/service/profile';
import { router } from '../../utils/router/router';
import { pages } from "../../router/pages";

export const actions = Object.freeze({
    performLogin,
    performLogout,
    fetchProfile,
});

async function performLogin({ commit }, credentials) {
    const response = await login.post(credentials);
    if (response.success) {
        commit(types.SET_ACTIVE_PROFILE, response.data.profile);
        commit(types.SET_AUTH_TOKEN, response.data.token);
        commit('app/SAVE_AUTH_TOKEN', response.data.token, { root: true });
        await router.push({ name: pages.Profile.Main });
    }
}

async function fetchProfile({ commit, state }, id) {
    const response = await profile.get(id, {
        headers: {
            Authorization: state.authToken
        }
    });
    if (response.success) {
        commit(types.REMOVE_ACTIVE_PROFILE);
        commit(types.SET_ACTIVE_PROFILE, response.data);
    } else if (response.error && response.error.response.status === 401) {
        commit(types.REMOVE_ACTIVE_PROFILE);
        commit(types.REMOVE_AUTH_TOKEN);
        commit('app/REMOVE_APP_DATA', null,  { root: true });
    }
}

async function performLogout({ commit }) {
    commit(types.REMOVE_ACTIVE_PROFILE);
    commit(types.REMOVE_AUTH_TOKEN);
    commit('app/REMOVE_APP_DATA', null,  { root: true });
    await router.push({ name: pages.Profile.Main });
}
