<template>
    <v-app>
        <router-view></router-view>
    </v-app>
</template>

<script>
import HelloWorld from './components/example/HelloWorld'
import Card from './components/example/Card'
import Table from './components/example/Table'
import CryptoCurrenciesTable from './components/example/CryptoCurrenciesTable'
import Dashboard from './components/dashboard/Dashboard'

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
        return {}
    }
}
</script>
