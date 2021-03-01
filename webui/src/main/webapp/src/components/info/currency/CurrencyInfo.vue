<template>
    <div>
    </div>
</template>
<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'CurrencyInfo',
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