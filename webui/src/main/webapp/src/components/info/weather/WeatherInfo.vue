<template>
    <div>
        <div>
            {{currentWeather}}
        </div>
        <div>
            <TemperatureForecastChart
                    v-if="weatherForecastDaysEntries"
                    :temperatureLabels="dayLabels"
                    :maxTempData="maxTemperatureData"
                    :minTempData="minTemperatureData"
            />
        </div>
        <div>
            <PressureForecastChart
                    v-if="weatherForecastDaysEntries"
                    :pressureLabels="dayLabels"
                    :pressureData="maxPressureData"
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
            ...mapGetters('weather', ['weatherForecastDaysEntries']),

            dayLabels: function() {
                return this.weatherForecastDaysEntries ? Array.from(this.weatherForecastDaysEntries.keys()) : null;
            },
            maxTemperatureData: function() {
                return this.weatherForecastDaysEntries ? Array.from(this.weatherForecastDaysEntries.values()).map(item => item.maxTemp) : null;
            },
            minTemperatureData: function() {
                return this.weatherForecastDaysEntries ? Array.from(this.weatherForecastDaysEntries.values()).map(item => item.minTemp) : null;
            },
            maxPressureData: function() {
                return this.weatherForecastDaysEntries ? Array.from(this.weatherForecastDaysEntries.values()).map(item => item.maxPressure) : null;
            }
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