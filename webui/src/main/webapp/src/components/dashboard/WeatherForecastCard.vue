<template>
    <v-card>
        <v-card-title>
            <v-layout display-1>Forecast</v-layout>
        </v-card-title>
        <v-card-text hidden-lg-and-up>
            <WeatherForecastChart v-if="items.length !== 0"
                                  :chartdata="items"
                                  :aspectRatio="chartAspectRatio">
            </WeatherForecastChart>
        </v-card-text>
    </v-card>
</template>

<script>
    import WeatherForecastChart from './WeatherForecastChart';
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