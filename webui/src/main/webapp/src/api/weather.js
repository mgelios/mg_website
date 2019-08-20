import axios from 'axios';

export default {
    getCurrentWeather: function(callback) {
        axios.get("/api/v1/weather/current")
            .then(response => {
                callback(response.data);
            });
    },
    getWeatherForecast: function(callback) {
        axios.get("/api/v1/weather/forecast")
            .then(response => {
               callback(response.data);
            });
    }
}