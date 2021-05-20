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
                <v-col class="text-sm-h3" cols="8">
                    {{currentWeatherData.temperature | degreeCelsius}}
                </v-col>
                <v-col cols="4"></v-col>
                <v-col cols="8">
                    Feels like: {{currentWeatherData.feelsLike | degreeCelsius}}
                </v-col>
            </v-row>
            <v-row>
                <v-col class="text-sm-body-1" cols="4">
                    Humidity: {{currentWeatherData.humidity | twoDigitsAfterPoint}}%
                </v-col>
                <v-col class="text-sm-body-1" cols="4">
                    Pressure: {{currentWeatherData.pressure | twoDigitsAfterPoint}} hpa
                </v-col>
                <v-col class="text-sm-body-1" cols="4">
                    UVI: {{currentWeatherData.uvi | twoDigitsAfterPoint}}
                </v-col>
            </v-row>
            <v-row>
                <v-col class="text-sm-body-1" cols="4">
                    Wind speed: {{currentWeatherData.windSpeed | twoDigitsAfterPoint}} kmh
                </v-col>
                <v-col class="text-sm-body-1" cols="4">
                    Visibility: {{currentWeatherData.visibility | twoDigitsAfterPoint}} m
                </v-col>
                <v-col class="text-sm-body-1" cols="4">
                    Details: {{currentWeatherData.mainInfo}}
                </v-col>
            </v-row>
            <v-row>
                <v-col class="text-sm-body-1" cols="4">
                    Sunrise: {{currentWeatherData.sunrise.value}}
                </v-col>
                <v-col class="text-sm-body-1" cols="4">
                    Sunset: {{currentWeatherData.sunset.value}}
                </v-col>
                <v-col class="text-sm-body-1" cols="4">
                    Wind degree: {{currentWeatherData.windDegree | twoDigitsAfterPoint}}
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