<template>
    <v-container grid-list-md>
        <v-layout wrap row>
            <v-flex xs12 lg6>
                <CurrentWeatherCard></CurrentWeatherCard>
            </v-flex>
            <v-flex xs12 lg6>
                <WeatherForecastCard></WeatherForecastCard>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import CurrentWeatherCard from './CurrentWeatherCard'
    import WeatherForecastCard from './WeatherForecastCard'

    export default {
        name: 'Dashboard',
        components: {
            CurrentWeatherCard,
            WeatherForecastCard
        }
    }
</script>

<style>

</style>