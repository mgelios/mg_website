<template>
    <v-card v-if="currentWeatherData">
        <v-list-item two-line>
            <v-list-item-content>
                <v-list-item-title class="headline">
                    {{currentWeatherData.cityName | capitalize}}
                </v-list-item-title>
                <v-list-item-subtitle>
                    {{currentWeatherData.description}}
                </v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>

        <v-card-text>
            <v-row align="center">
                <v-col class="text-sm-h2" cols="8">
                    {{currentWeatherData.temperature | degreeCelsius}}
                </v-col>
                <v-col cols="4"></v-col>
                <v-col cols="8">
                    Feels like: {{currentWeatherData.feelsLike}}
                </v-col>
            </v-row>
            <v-row>
                <v-col class="text-sm-h5" cols="4">
                    Humidity: {{currentWeatherData.humidity}}%
                </v-col>
                <v-col class="text-sm-h5" cols="4">
                    Pressure: {{currentWeatherData.pressure}} hpa
                </v-col>
                <v-col class="text-sm-h5" cols="4">
                    UVI: {{currentWeatherData.uvi}}
                </v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: 'CurrentWeather',
        props: {
            currentWeatherData: null,
        }
    }
</script>