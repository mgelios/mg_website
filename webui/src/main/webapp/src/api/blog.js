import axios from 'axios';

export default {
    createCategory: function(categoryData, callback) {
        axios
            .post("/api/v1/blog/category", categoryData)
            .then(response => {
                callback(response.data);
            })
    }
}