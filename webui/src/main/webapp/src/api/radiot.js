import axios from 'axios';

export default {
    getArticles: function (callback) {
        axios.get("http://localhost:8080/api/v1/news/radiot/articles")
            .then(response => {
                callback(response.data);
            });
    }
}