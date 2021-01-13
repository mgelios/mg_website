import { types } from './types';

export const actions = Object.freeze({

});

async function fetchArticles({ commit }){
    const articles = await smth;
    commit(types.SET_ARTICLES, articles);
}