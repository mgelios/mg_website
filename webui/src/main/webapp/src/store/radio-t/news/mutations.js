import { types } from './types';

export const mutations = {
    [types.SET_ARTICLES](state, values) {
        state.articles = values;
    },
};