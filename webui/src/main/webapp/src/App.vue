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
            <router-view></router-view>
        </v-content>
        <v-footer app></v-footer>
    </v-app>
</template>

<script>
import HelloWorld from './components/example/HelloWorld'
import Card from './components/example/Card'
import Table from './components/example/Table'
import CryptoCurrenciesTable from './components/example/CryptoCurrenciesTable'
import Dashboard from './components/weather/Dashboard'

export default {
    name: 'App',
    components: {
        HelloWorld,
        Card,
        Table,
        CryptoCurrenciesTable,
        Dashboard
    },
    data () {
        return {
          //
        }
    }
}
</script>
