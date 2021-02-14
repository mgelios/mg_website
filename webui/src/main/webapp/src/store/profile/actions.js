import { types } from './types';
import { login, profile } from '../../api/service/profile';
import { router } from '../../utils/router/router';

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
        router.push({ name: 'profile' });
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
    }
}

async function performLogout({ commit }) {
    commit(types.REMOVE_ACTIVE_PROFILE);
    commit(types.REMOVE_AUTH_TOKEN);
    commit('app/REMOVE_APP_DATA', null,  { root: true });
    router.push({ name: 'profile' });
}