import { types } from './types';
import { radiotArticle } from "../../../api/service/radiot";

export const actions = Object.freeze({
    fetchArticles,
});

async function fetchArticles({ commit }){
    const articles = await radiotArticle.getList();
    commit(types.SET_ARTICLES, articles);
}