<template>
    <v-app>
        <v-navigation-drawer app>
            <v-toolbar flat>
                <v-icon x-large>pool</v-icon>
            </v-toolbar>
        </v-navigation-drawer>
        <v-toolbar app flat>
            <!--<HelloWorld/>-->
        </v-toolbar>
        <v-content>
            <v-container>
                <v-layout wrap row>
                    <!-- <router-view></router-view> -->
                    <!--<Card/>-->
                    <!--<Table/>-->
                    <!--<CryptoCurrenciesTable/>-->
                    <v-flex xs12 lg6>
                        <CurrentWeatherCard></CurrentWeatherCard>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-content>
        <v-footer app></v-footer>
    </v-app>
</template>

<script>
import HelloWorld from './components/example/HelloWorld'
import Card from './components/example/Card'
import Table from './components/example/Table'
import CryptoCurrenciesTable from './components/example/CryptoCurrenciesTable'
import CurrentWeatherCard from './components/weather/CurrentWeatherCard'

export default {
    name: 'App',
    components: {
        HelloWorld,
        Card,
        Table,
        CryptoCurrenciesTable,
        CurrentWeatherCard
    },
    data () {
        return {
          //
        }
    }
}
</script>
