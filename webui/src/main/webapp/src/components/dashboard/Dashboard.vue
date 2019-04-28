<template>
    <v-container grid-list-md fluid>
        <v-layout row hidden-md-and-down>
            <v-flex xs12 lg4>
                <v-layout wrap column>
                    <v-flex xs12 lg6>
                        <CurrentWeatherCard></CurrentWeatherCard>
                    </v-flex>
                    <v-flex xs12 lg6>
                        <WeatherForecastCard></WeatherForecastCard>
                    </v-flex>
                </v-layout>
            </v-flex>
            <v-flex xs12 lg4>
                <v-layout wrap column>
                    <v-flex xs12 lg6>
                        <CurrencyCard></CurrencyCard>
                    </v-flex>
                </v-layout>
                <v-layout wrap column>
                    <v-flex xs12 lg6>
                        <CurrencyConversionsCard></CurrencyConversionsCard>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>

        <v-layout column hidden-lg-and-up>
            <v-flex>
                <CurrentWeatherCard></CurrentWeatherCard>
            </v-flex>
            <v-flex>
                <WeatherForecastCard :chartAspectRatio="1"></WeatherForecastCard>
            </v-flex>
            <v-flex xs12 lg6>
                <CurrencyCard></CurrencyCard>
            </v-flex>
            <v-flex xs12 lg6>
                <CurrencyConversionsCard></CurrencyConversionsCard>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import CurrentWeatherCard from './CurrentWeatherCard'
    import WeatherForecastCard from './WeatherForecastCard'
    import CurrencyCard from './CurrencyCard'
    import CurrencyConversionsCard from './CurrencyConversionsCard'

    export default {
        name: 'Dashboard',
        components: {
            CurrentWeatherCard,
            WeatherForecastCard,
            CurrencyCard,
            CurrencyConversionsCard
        }
    }
</script>

<style>

</style>