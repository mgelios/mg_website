import blog from '../../api/blog';

const state = {
    categories : [],
    subcategories : []
};

const getters = {};

const actions = {
    triggerCategoryCreation(context, categoryData) {
        blog.createCategory(category => {
            context.commit('createCategory', category);
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
