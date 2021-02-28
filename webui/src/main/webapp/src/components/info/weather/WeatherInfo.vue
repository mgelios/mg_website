<template>
    <div>
        {{currentWeather}}
        {{weatherForecast}}
    </div>
</template>
<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'WeatherInfo',
        components: {
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