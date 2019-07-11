<template>
    <v-card>
        <v-card-title class="blue-grey darken-1">
            <v-layout headline class="white--text">{{currentWeather.cityName | capitalize}} {{currentWeather.temperature | degreeCelsius}}</v-layout>
        </v-card-title>
        <v-card-text>
            <v-layout row>
                <v-flex xs12 sm6>
                    <v-img v-bind:src="getImage(currentWeather.icon)"></v-img>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-layout headline class="text-xs-center">{{currentWeather.description | capitalize}}</v-layout>
                    <v-list>
                        <v-list-tile>
                            <v-list-tile-content>Humidity:</v-list-tile-content>
                            <v-list-tile-action>{{currentWeather.humidity}}%</v-list-tile-action>
                        </v-list-tile>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-tile>
                            <v-list-tile-content>Pressure:</v-list-tile-content>
                            <v-list-tile-action>{{(currentWeather.pressure*(0.750062)).toFixed(2)}}</v-list-tile-action>
                        </v-list-tile>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-tile>
                            <v-list-tile-content>Visibility:</v-list-tile-content>
                            <v-list-tile-action>{{currentWeather.visibility}} m</v-list-tile-action>
                        </v-list-tile>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-tile>
                            <v-list-tile-content>Wind speed:</v-list-tile-content>
                            <v-list-tile-action>{{currentWeather.windSpeed}} m/s</v-list-tile-action>
                        </v-list-tile>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-tile>
                            <v-list-tile-content>Sunrise:</v-list-tile-content>
                            <v-list-tile-action>{{currentWeather.sunrise[3]+':'+currentWeather.sunrise[4]}}</v-list-tile-action>
                        </v-list-tile>
                        <v-divider class="ma-0"></v-divider>
                        <v-list-tile>
                            <v-list-tile-content>Sunset:</v-list-tile-content>
                            <v-list-tile-action>{{currentWeather.sunset[3]+':'+currentWeather.sunset[4]}}</v-list-tile-action>
                        </v-list-tile>
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
                weatherImagesFolder: '../../../../assets/img/weather/',
                weatherImagesExtension: '.svg'
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
