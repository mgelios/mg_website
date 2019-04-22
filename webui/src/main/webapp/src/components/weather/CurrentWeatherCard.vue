<template>
    <v-card>
        <v-card-title>
            <v-layout display-2>{{cardContent.cityName | capitalize}} {{cardContent.temperature | degree}}</v-layout>
        </v-card-title>
        <v-card-text>
            <v-layout display-1>{{cardContent.description}}</v-layout>
            <v-layout headline> {{cardContent.minimalTemperature | degree}} - {{cardContent.maximumTemperature | degree}} </v-layout>
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
        filters: {
            capitalize: function(string) {
                if (!string)
                    return '';
                string = string.toString();
                return string.charAt(0).toUpperCase() + string.slice(1);
            },
            degree: function(value) {
                var string = "";
                if (!value) return '';
                if (value > 0) {
                    string = "+";
                } else if (value < 0) {
                    string = "-";
                }
                string = string + value.toString() + "°C";
                return string;
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
