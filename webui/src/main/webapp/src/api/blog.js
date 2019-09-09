import axios from 'axios';

export default {
    createCategory: function(callback, categoryData) {
        axios
            .post("/api/v1/blog/category", categoryData)
            .then(response => {
                callback(response.data);
            })
    }
}