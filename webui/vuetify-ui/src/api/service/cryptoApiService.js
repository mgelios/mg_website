import axios from 'axios';

export default {
    getCryptoCurrencies: function(callback) {
        axios
            .get("/api/v1/finance/crypto/list")
            .then(response => {
               callback(response.data);
            });
    },
    getCryptoMarket: function(callback) {
        axios
            .get("/api/v1/finance/crypto/market")
            .then(response => {
                callback(response.data);
            });
    }
}