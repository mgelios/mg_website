<template>
    <div>
        <v-navigation-drawer app v-model="navDrawer" :mini-variant.sync="miniToolbar">
            <v-toolbar flat>
                <v-list>
                    <v-list-tile avatar>
                        <v-list-tile-avatar>
                            <v-icon x-large>dashboard</v-icon>
                        </v-list-tile-avatar>
                        <v-list-tile-content>
                            <v-list-tile-title>Dashboard</v-list-tile-title>
                        </v-list-tile-content>
                        <v-list-tile-action>
                            <v-btn icon @click.stop="miniToolbar = !miniToolbar">
                                <v-icon>chevron_left</v-icon>
                            </v-btn>
                        </v-list-tile-action>
                    </v-list-tile>
                </v-list>
            </v-toolbar>
            <v-list>
                <v-list-tile
                        v-for="navItem in navigationItems"
                        :key="navItem.title">
                    <v-list-tile-action>
                        <v-icon>{{navItem.icon}}</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>{{navItem.title}}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-navigation-drawer>
        <v-toolbar app flat>
            <v-toolbar-side-icon @click.native="navDrawer = !navDrawer"></v-toolbar-side-icon>
            <router-link :to="{ name: 'profile' }"><v-icon large>perm_identity</v-icon></router-link>
            <!--<HelloWorld/>-->
        </v-toolbar>
        <v-content>
            <v-container fluid grid-list-md>
                <v-layout row wrap>
                    <v-flex xs12 md6 lg3 d-flex>
                        <CurrentWeatherCard></CurrentWeatherCard>
                    </v-flex>
                    <v-flex xs12 md6 lg3 d-flex>
                        <WeatherForecastCard :chartAspectRatio="1.2"></WeatherForecastCard>
                    </v-flex>
                    <v-flex xs12 md6 lg3 d-flex>
                        <CurrencyCard></CurrencyCard>
                    </v-flex>
                    <v-flex xs12 md6 lg3 d-flex>
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
        <v-footer app></v-footer>
    </div>
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
                navDrawer: true,
                miniToolbar: true,
                navigationItems: [
                    {
                        title: 'Weather',
                        icon: 'cloud',
                        route: ''
                    },
                    {
                        title: 'Finance',
                        icon: 'euro_symbol',
                        route: ''
                    },
                    {
                        title: 'Crypto market',
                        icon: 'list_alt',
                        route: ''
                    },
                    {
                        title: 'Radio-T',
                        icon: 'radio',
                        route: ''
                    }
                ]
            }
        }
    }
</script>

<style>

</style>