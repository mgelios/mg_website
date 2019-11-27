<template>
    <v-card height="100%">
        <v-card-title class="blue-grey darken-1">
            <v-layout headline class="white--text">Forecast</v-layout>
        </v-card-title>
        <v-card-text>
            <WeatherForecastChart v-if="items.length !== 0"
                                  :chartdata="items"
                                  :aspectRatio="chartAspectRatio">
            </WeatherForecastChart>
        </v-card-text>
    </v-card>
</template>

<script>
    import WeatherForecastChart from './charts/WeatherForecastChart';
    import { mapState } from 'vuex';

    export default {
        name: 'WeatherForecastCard',
        components: {
            WeatherForecastChart
        },
        mounted: function() {
            this.$store.dispatch('Weather/getWeatherForecast');
        },
        props: {
            chartAspectRatio: {
                default: 2
            }
        },
        computed: {
            ...mapState({
                items : state => state.Weather.weatherForecast
            })
        }
    }
</script>

<style>

</style>