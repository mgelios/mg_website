import { types } from './types';
import { login } from '../../api/service/profile';
export const actions = Object.freeze({
    performLogin,
    performLogout,
});

async function performLogin({ state }, credentials) {
    var type = types.REMOVE_PROFILE;
    state.profile = type;
    console.log(type);
    console.log(credentials);

    await login.post(credentials);
}

async function performLogout() {

}