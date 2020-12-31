import blog from '../../api/service/blog';

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
    },
    triggerCategoryReceiving(context) {
        blog.getCategories(categories => {
            context.commit('setCategories', categories);
        })
    }
};

const mutations = {
    setCategories: function(state, receivedCategories) {
        state.categories = receivedCategories;
    },
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
