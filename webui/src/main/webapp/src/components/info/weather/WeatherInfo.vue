<template>
    <div>
        <div>
            {{currentWeather}}
        </div>
        <div>
            <TemperatureForecastChart
                    v-if="weatherForecastGroupedByDay"
                    :temperatureLabels="daysCollection"
                    :maxTempData="maxTempForecast"
                    :minTempData="minTempForecast"
            />
        </div>
        <div>
            <PressureForecastChart
                    v-if="weatherForecastGroupedByDay"
                    :pressureLabels="daysCollection"
                    :pressureData="maxPressureForecast"
            />
        </div>
    </div>
</template>

<script>
    import { mapState, mapActions, mapGetters } from 'vuex';
    import PressureForecastChart from "./PressureForecastChart";
    import TemperatureForecastChart from "./TemperatureForecastChart";

    export default {
        name: 'WeatherInfo',
        components: {
            TemperatureForecastChart,
            PressureForecastChart
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('weather', ['currentWeather']),
            ...mapGetters('weather',[
                'daysCollection',
                'weatherForecastGroupedByDay',
                'maxTempForecast',
                'minTempForecast',
                'maxPressureForecast'
            ]),

        },
        mounted() {
            this.fetchCurrentWeather();
            this.fetchWeatherForecast();
        },
        methods: {
            ...mapActions('weather', ['fetchCurrentWeather', 'fetchWeatherForecast']),
        },
    }
</script>