<template>
    <div>
        <CurrentWeather
                :currentWeatherData="currentWeather"
        />
        <v-list three-line v-if="weatherForecastGroupedByDay">
            <WeatherForecastItem
                    v-for="(item, index) in groupedForecastAsList"
                    :weatherForecastItemData="item"
                    v-bind:key="index"
            />
        </v-list>
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
    import CurrentWeather from "./CurrentWeather";
    import PressureForecastChart from "./PressureForecastChart";
    import TemperatureForecastChart from "./TemperatureForecastChart";
    import WeatherForecastItem from "./WeatherForecastItem";

    export default {
        name: 'WeatherInfo',
        components: {
            TemperatureForecastChart,
            PressureForecastChart,
            CurrentWeather,
            WeatherForecastItem,
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('weather', ['currentWeather', 'weatherForecastGroupedByDay']),
            ...mapGetters('weather',[
                'daysCollection',
                'maxTempForecast',
                'minTempForecast',
                'maxPressureForecast',
                'groupedForecastAsList',
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