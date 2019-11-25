<template>
    <v-content>
        <v-container fluid grid-list-md>
            <v-layout row wrap>
                <v-flex xs12>
                    <v-card>
                        <v-card-text>
                            <v-layout row>
                                <v-flex xs0 sm2 lg4></v-flex>
                                <v-flex xs6 sm4 lg2>
                                    <v-img v-bind:src="getImage(currentWeather.icon)"></v-img>
                                </v-flex>
                                <v-flex xs6 sm4 lg2>
                                    <v-layout class="display-3 text-xs-center">{{currentWeather.temperature | degreeCelsius}}</v-layout>
                                    <v-layout class="headline">{{currentWeather.mainInfo | capitalize}}</v-layout>
                                </v-flex>
                                <v-flex xs0 sm2 lg4></v-flex>
                            </v-layout>
                            <v-layout row>
                                <v-flex xs0 sm2 lg3 xl4></v-flex>
                                <v-flex xs12 sm8 lg6 xl4>
                                    <v-layout row wrap>
                                        <v-flex xs6 sm4 subheading>Details: {{currentWeather.description}}</v-flex>
                                        <v-flex xs6 sm4 subheading>Humidity: {{currentWeather.humidity}}%</v-flex>
                                        <v-flex xs6 sm4 subheading>Pressure: {{(currentWeather.pressure*(0.750062)).toFixed(2)}}</v-flex>
                                        <v-flex xs6 sm4 subheading>Visibility: {{currentWeather.visibility}} m</v-flex>
                                        <v-flex xs6 sm4 subheading>Wind speed: {{currentWeather.windSpeed}} m/s</v-flex>
                                        <v-flex xs6 sm4 subheading>Sunrise: {{currentWeather.sunrise[3]+':'+currentWeather.sunrise[4]}}</v-flex>
                                        <v-flex xs6 sm4 subheading>UVI: {{currentWeather.uvi.toFixed(2)}}</v-flex>
                                        <v-flex xs6 sm4 subheading>Wind degree: {{currentWeather.windDegree}}</v-flex>
                                        <v-flex xs6 sm4 subheading>Sunset: {{currentWeather.sunset[3]+':'+currentWeather.sunset[4]}}</v-flex>
                                    </v-layout>
                                </v-flex>
                                <v-flex xs0 sm2 lg3 xl4></v-flex>
                            </v-layout>
                            <v-layout row wrap>
                                <v-flex xs12 hidden-md-and-up>
                                    <WeatherChart v-if="forecastItems.length !== 0"
                                                  :chartdata="forecastItems"
                                                  :aspectRatio="2">
                                    </WeatherChart>
                                </v-flex>
                                <v-flex xs12 hidden-sm-and-down>
                                    <WeatherChart v-if="forecastItems.length !== 0"
                                                          :chartdata="forecastItems"
                                                          :aspectRatio="4">
                                    </WeatherChart>
                                </v-flex>
                            </v-layout>
                        </v-card-text>
                    </v-card>
                </v-flex>
            </v-layout>
        </v-container>
    </v-content>
</template>

<script>
    import { mapState } from 'vuex';
    import WeatherChart from './charts/WeatherChart'

    export default {
        name: 'Weather',
        components: {
            WeatherChart
        },
        mounted: function() {
            this.$store.dispatch('Weather/getCurrentWeather');
            this.$store.dispatch('Weather/getWeatherForecast');
        },
        computed: {
            ...mapState({
                currentWeather : state => state.Weather.currentWeather,
                forecastItems : state => state.Weather.weatherForecast
            })
        },
        methods: {
            getImage: function(name) {
                var images = require.context('../../../assets/img/weather/', false, /\.svg$/);
                if (name) {
                    return images('./' + name + '.svg');
                } else {
                    return images('./01d.svg');
                }
            }
        }
    }
</script>

<style>

</style>
