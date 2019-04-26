<template>
    <v-container grid-list-md fluid>
        <v-layout row>
            <v-flex xs12 lg6>
                <v-layout wrap column>
                    <v-flex xs12 lg6>
                        <CurrentWeatherCard></CurrentWeatherCard>
                    </v-flex>
                    <v-flex xs12 lg6>
                        <WeatherForecastCard></WeatherForecastCard>
                    </v-flex>
                </v-layout>
            </v-flex>
            <v-flex xs12 lg6>
                <v-layout wrap column>
                    <v-flex xs12 lg6>
                        <CurrencyCard></CurrencyCard>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import CurrentWeatherCard from './CurrentWeatherCard'
    import WeatherForecastCard from './WeatherForecastCard'
    import CurrencyCard from './CurrencyCard'

    export default {
        name: 'Dashboard',
        components: {
            CurrentWeatherCard,
            WeatherForecastCard,
            CurrencyCard
        }
    }
</script>

<style>

</style>