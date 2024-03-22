<template>
    <v-content>
        <v-container fluid grid-list-md>
            <v-layout row wrap fill-height>
                <v-flex xs12 md6 lg3>
                    <CurrentWeatherCard></CurrentWeatherCard>
                </v-flex>
                <v-flex xs12 md6 lg3>
                    <WeatherForecastCard :chartAspectRatio="1.2"></WeatherForecastCard>
                </v-flex>
                <v-flex xs12 md6 lg3>
                    <CurrencyCard></CurrencyCard>
                </v-flex>
                <v-flex xs12 md6 lg3>
                    <CurrencyConversionsCard></CurrencyConversionsCard>
                </v-flex>
            </v-layout>

            <v-layout row wrap>
                <v-flex xs12 lg4>
                    <CryptoMarketCard></CryptoMarketCard>
                </v-flex>
                <v-flex xs12 lg8>
                    <CryptoCurrenciesCard></CryptoCurrenciesCard>
                </v-flex>
            </v-layout>

            <v-layout row wrap>
                <v-flex xs12 lg6>
                    <RadiotNewsCard></RadiotNewsCard>
                </v-flex>
            </v-layout>
        </v-container>
    </v-content>
</template>

<script>
    import CurrentWeatherCard from './cards/CurrentWeatherCard'
    import WeatherForecastCard from './cards/WeatherForecastCard'
    import CurrencyCard from './cards/CurrencyCard'
    import CurrencyConversionsCard from './cards/CurrencyConversionsCard'
    import CryptoCurrenciesCard from './cards/CryptoCurrenciesCard'
    import CryptoMarketCard from './cards/CryptoMarketCard'
    import RadiotNewsCard from './cards/RadiotNewsCard'

    export default {
        name: 'DashboardMain',
        components: {
            CurrentWeatherCard,
            WeatherForecastCard,
            CurrencyCard,
            CurrencyConversionsCard,
            CryptoCurrenciesCard,
            CryptoMarketCard,
            RadiotNewsCard
        },
        data: function() {
            return {
            }
        }
    }
</script>

<style>

</style>
