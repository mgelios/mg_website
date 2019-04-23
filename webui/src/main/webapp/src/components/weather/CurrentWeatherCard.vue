<template>
    <v-card>
        <v-card-title>
            <v-layout display-2>{{cardContent.cityName | capitalize}} {{cardContent.temperature | degreeCelsius}}</v-layout>
        </v-card-title>
        <v-card-text>
            <v-layout display-1>{{cardContent.description}}</v-layout>
            <v-layout headline> {{cardContent.minimalTemperature | degreeCelsius}} - {{cardContent.maximumTemperature | degreeCelsius}} </v-layout>
        </v-card-text>
    </v-card>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CurrentWeatherCard',
        data: function() {
            return {
            }
        },
        mounted: function() {
            this.$store.dispatch('Weather/getCurrentWeather');
        },
        computed: {
            ...mapState({
                cardContent : state => state.Weather.currentWeather
            })
        }
    }
</script>

<style>

</style>
