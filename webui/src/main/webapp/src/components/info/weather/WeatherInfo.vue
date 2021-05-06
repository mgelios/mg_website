<template>
    <div>
        <div>
            {{currentWeather}}
        </div>
        <div>
            {{weatherForecastDaysEntries()}}
        </div>
        <div>
            <WeatherInfoChart/>
        </div>
    </div>
</template>
<script>
    import { mapState, mapActions, mapGetters } from 'vuex';
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
            ...mapGetters('weather', ['weatherForecastDaysEntries']),

        }
    }
</script>