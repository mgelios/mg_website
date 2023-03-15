import axios from 'axios';

export default {
    login: function(callback) {
        axios
            .post("/login")
            .then();
    }
}