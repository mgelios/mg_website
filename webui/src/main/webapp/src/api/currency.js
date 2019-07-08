import axios from 'axios';

export default {
    getExchangeRates: function (callback) {
        axios.get("http://localhost:8080/api/v1/finance/currency/values")
            .then(response => {
                callback(response.data);
            });
    },
    getConversions: function (callback) {
        axios.get("http://localhost:8080/api/v1/finance/currency/conversions")
            .then(response => {
                callback(response.data);
            });
    },
    getStatistics: function (callback) {
        axios.get("http://localhost:8080/api/v1/finance/currency/statistics")
            .then(response => {
                callback(response.data);
            });
    }
}