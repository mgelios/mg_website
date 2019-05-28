<template>
    <div>
        <v-navigation-drawer app v-model="navDrawer">
            <v-toolbar flat>
                <v-icon x-large>pool</v-icon>
            </v-toolbar>
        </v-navigation-drawer>
        <v-toolbar app flat>
            <v-toolbar-side-icon @click.native="navDrawer = !navDrawer"></v-toolbar-side-icon>
            <router-link :to="{ name: 'profile' }"><v-icon large>perm_identity</v-icon></router-link>
            <!--<HelloWorld/>-->
        </v-toolbar>
        <v-content grid-list-md fluid>
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
                </v-flex>
                <v-flex xs12 lg4>
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

            <v-layout row>
                <v-flex xs12 lg4>
                    <CryptoMarketCard></CryptoMarketCard>
                </v-flex>
                <v-flex xs12 lg8>
                    <CryptoCurrenciesCard></CryptoCurrenciesCard>
                </v-flex>
            </v-layout>

            <v-layout row>
                <v-flex xs12 lg6>
                    <RadiotNewsCard></RadiotNewsCard>
                </v-flex>
            </v-layout>
        </v-content>
        <v-footer app></v-footer>
    </div>
</template>

<script>
    import CurrentWeatherCard from './CurrentWeatherCard'
    import WeatherForecastCard from './WeatherForecastCard'
    import CurrencyCard from './CurrencyCard'
    import CurrencyConversionsCard from './CurrencyConversionsCard'
    import CryptoCurrenciesCard from './CryptoCurrenciesCard'
    import CryptoMarketCard from './CryptoMarketCard'
    import RadiotNewsCard from './RadiotNewsCard'

    export default {
        name: 'Dashboard',
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
                navDrawer: true
            }
        }
    }
</script>

<style>

</style>