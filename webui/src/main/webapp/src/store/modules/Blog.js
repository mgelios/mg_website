import blog from '../../api/blog';

const state = {
    categories : [],
    subcategories : []
};

const getters = {};

const actions = {
    triggerCategoryCreation({ commit,categoryData }) {
        blog.createCategory(category => {
            commit('createCategory', category);
        }, categoryData);
    }
};

const mutations = {
    createCategory: function(state, createdCategory) {
        state.categories.push(createdCategory);
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}
