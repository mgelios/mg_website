import blogApiService from '../../api/service/blogApiService';

const state = {
    categories : [],
    subcategories : []
};

const getters = {};

const actions = {
    triggerCategoryCreation(context, categoryData) {
        blogApiService.createCategory(category => {
            context.commit('createCategory', category);
        }, categoryData);
    },
    triggerCategoryReceiving(context) {
        blogApiService.getCategories(categories => {
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
