import weather from '../../api/service/radiotApiService';

const state = {
    articles: []
};

const getters = {
};

const actions = {
    getArticles(context) {
        weather.getArticles(data => {
            context.commit('setArticles', data);
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