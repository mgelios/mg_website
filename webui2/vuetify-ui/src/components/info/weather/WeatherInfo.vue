<template>
    <div>
    <v-row>
        <v-col>
            <CurrentWeather :currentWeatherData="currentWeather"/>
        </v-col>
        <v-col>
            <v-list three-line v-if="weatherForecastGroupedByDay">
                <WeatherForecastItem
                        v-for="(item, index) in groupedForecastAsList"
                        :weatherForecastItemData="item"
                        v-bind:key="index"
                />
            </v-list>
        </v-col>
    </v-row>
    <v-row>
        <v-col col-xs="12" col-sm="6">
            <TemperatureForecastChart
                    v-if="weatherForecastGroupedByDay"
                    :temperatureLabels="daysCollection"
                    :maxTempData="maxTempForecast"
                    :minTempData="minTempForecast"
            />
        </v-col>
        <v-col col-xs="12" col-sm="6">
            <PressureForecastChart
                    v-if="weatherForecastGroupedByDay"
                    :pressureLabels="daysCollection"
                    :pressureData="maxPressureForecast"
            />
        </v-col>
    </v-row>
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