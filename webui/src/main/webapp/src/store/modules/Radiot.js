import weather from '../../api/radiot';

const state = {
    articles: []
};

const getters = {
};

const actions = {
    getArticles({ commit }) {
        weather.getArticles(data => {
            commit('setArticles', data);
        })
    }
};

const mutations = {
    setArticles(state, data) {
        state.articles = data;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}