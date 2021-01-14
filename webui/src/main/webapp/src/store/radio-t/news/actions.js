import { types } from './types';

export const actions = Object.freeze({
    fetchArticles,
});

async function fetchArticles({ commit }){
    const articles = await smth;
    commit(types.SET_ARTICLES, articles);
}