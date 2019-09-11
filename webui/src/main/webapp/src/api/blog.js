import axios from 'axios';

export default {
    getCategories: function(callback) {
        axios
            .get("/api/v1/blog/category/all")
            .then(response => {
                callback(response.data);
            });
    },
    createCategory: function(callback, categoryData) {
        axios
            .post("/api/v1/blog/category", categoryData)
            .then(response => {
                callback(response.data);
            })
    }
}