import { types } from './types';
import { login } from '../../api/service/profile';
import { router } from '../../utils/router/router';

export const actions = Object.freeze({
    performLogin,
    performLogout,
    fetchProfile,
});

async function performLogin({ commit }, credentials) {
    const response = await login.post(credentials);
    if (response.success) {
        console.log(response.data);
        commit(types.SET_ACTIVE_PROFILE, response.data.data.profile);
        commit(types.SET_AUTH_TOKEN, response.data.data.token);
        router.push({ name: 'dashboardMainPage' });
    }
}

async function fetchProfile({ commit, state }, id) {
    const response = await login.get(id, {
        headers: {
            Authorization: state.authToken
        }
    });
    if (response.success) {
        commit(types.REMOVE_ACTIVE_PROFILE);
        commit(types.SET_ACTIVE_PROFILE, response.data.data);
    }
}

async function performLogout({ commit }) {
    commit(types.REMOVE_ACTIVE_PROFILE);
    commit(types.REMOVE_AUTH_TOKEN);
    router.push({ name: 'dashboardMainPage' });
}