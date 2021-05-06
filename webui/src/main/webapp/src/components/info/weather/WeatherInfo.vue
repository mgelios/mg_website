<template>
    <div>
        <div>
            {{currentWeather}}
        </div>
        <div>
            <WeatherInfoChart/>
        </div>
    </div>
</template>
<script>
    import { mapState, mapActions } from 'vuex';
    import WeatherInfoChart from "./WeatherInfoChart";

    export default {
        name: 'WeatherInfo',
        components: {
            WeatherInfoChart
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('weather', ['currentWeather', 'weatherForecast']),
        },
        mounted() {
            this.fetchCurrentWeather();
            this.fetchWeatherForecast();
        },
        methods: {
            ...mapActions('weather', ['fetchCurrentWeather', 'fetchWeatherForecast']),

        }
    }
</script>