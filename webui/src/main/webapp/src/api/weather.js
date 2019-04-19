import axios from 'axios';

export default {
    getCurrentWeather: function(callback) {
        axios.get("http://localhost:8080/api/v1/weather/current")
            .then(response => {
                callback(response.data);
            });
    },
    getWeatherForecast: function(callback) {
        axios.get("http://localhost:8080/api/v1/weather/forecast")
            .then(response => {
               callback(response.data);
            });
    }
}