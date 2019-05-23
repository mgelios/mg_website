import axios from 'axios';

export default {
    login: function(callback) {
        axios
            .post("http://localhost:8080/login")
            .then();
    }
}