import axios from 'axios';

export default {
    getCryptoCurrencies: function(callback) {
        axios
            .get("http://localhost:8080/api/v1/finance/crypto/list")
            .then(response => {
               callback(response.data);
            });
    },
    getCryptoMarket: function(callback) {
        axios
            .get("http://localhost:8080/api/v1/finance/crypto/market")
            .then(response => {
                callback(response.data);
            });
    }
}