<template>
    <v-card>
        <v-card-title class="blue-grey darken-1">
            <v-layout headline class="white--text">
                <v-img v-if="currentWeather.icon" v-bind:src="getImage(currentWeather.icon)" height="1.5em" contain style="filter: invert(100%);" max-width="1.5em" />
                {{currentWeather.cityName | capitalize}} {{currentWeather.temperature | degreeCelsius}}
            </v-layout>
        </v-card-title>
        <v-card-text>
            <v-layout row>
                <v-flex xs12>
                    <v-layout headline class="text-xs-center">{{currentWeather.description | capitalize}}</v-layout>
                    <v-list v-if="currentWeather.pressure">
                        <v-list-item>
                            <v-list-item-content>Humidity:</v-list-item-content>
                            <v-list-item-action>{{currentWeather.humidity}}%</v-list-item-action>
                        </v-list-item>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-item>
                            <v-list-item-content>Pressure:</v-list-item-content>
                            <v-list-item-action>{{(currentWeather.pressure*(0.750062)).toFixed(2)}}</v-list-item-action>
                        </v-list-item>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-item>
                            <v-list-item-content>Visibility:</v-list-item-content>
                            <v-list-item-action>{{currentWeather.visibility}} m</v-list-item-action>
                        </v-list-item>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-item>
                            <v-list-item-content>Wind speed:</v-list-item-content>
                            <v-list-item-action>{{currentWeather.windSpeed}} m/s</v-list-item-action>
                        </v-list-item>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-item>
                            <v-list-item-content>Sunrise:</v-list-item-content>
                            <v-list-item-action>{{currentWeather.sunrise[3]+':'+currentWeather.sunrise[4]}}</v-list-item-action>
                        </v-list-item>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-item>
                            <v-list-item-content>Sunset:</v-list-item-content>
                            <v-list-item-action>{{currentWeather.sunset[3]+':'+currentWeather.sunset[4]}}</v-list-item-action>
                        </v-list-item>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-item>
                            <v-list-item-content>UVI:</v-list-item-content>
                            <v-list-item-action>{{currentWeather.uvi.toFixed(2)}}</v-list-item-action>
                        </v-list-item>
                    </v-list>
                </v-flex>
            </v-layout>
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
            })
        },
        methods: {
            getImage: function(name) {
                var images = require.context('../../../../assets/img/weather/', false, /\.svg$/);
                return images('./' + name + '.svg');
            }
        }
    }
</script>

<style>

</style>
