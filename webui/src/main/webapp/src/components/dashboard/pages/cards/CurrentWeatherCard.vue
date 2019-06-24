<template>
    <v-card>
        <v-card-title class="blue-grey darken-1">
            <v-layout headline class="white--text">{{currentWeather.cityName | capitalize}} {{currentWeather.temperature | degreeCelsius}}</v-layout>
        </v-card-title>
        <v-card-text>
            <v-img v-bind:src="imageUrl"></v-img>
            <v-layout display-1>{{currentWeather.description}}</v-layout>
            <v-layout headline> {{currentWeather.minimalTemperature | degreeCelsius}} - {{currentWeather.maximumTemperature | degreeCelsius}} </v-layout>
            <v-layout headline></v-layout>
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
                currentWeather : state => state.Weather.currentWeather
            }),
            imageUrl: function() {
//                if (this.currentWeather.icon) {
//                    return '../../../assets/img/weather/' + this.currentWeather.icon + '.svg';
//                } else {
                    return '../../../assets/img/weather/01d.svg';
//                }
            }
        }
    }
</script>

<style>

</style>
