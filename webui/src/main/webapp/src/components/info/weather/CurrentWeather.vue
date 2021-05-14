<template>
    <v-card v-if="currentWeatherData">
        <v-card-text>
            <v-row align="center">
                <v-col class="display-3" cols="6">
                    {{currentWeatherData.temperature | degreeCelsius}}
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