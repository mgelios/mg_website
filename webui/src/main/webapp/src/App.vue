<template>
  <v-app>
    <v-navigation-drawer app>
    </v-navigation-drawer>
    <v-toolbar app>
      <HelloWorld/>
    </v-toolbar>
    <v-content>
      <v-container fluid>
        <!-- <router-view></router-view> -->
        <Card/>
        <Table/>
        <CryptoCurrenciesTable/>
      </v-container>
    </v-content>
    <v-footer app></v-footer>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Card from './components/Card'
import Table from './components/Table'
import CryptoCurrenciesTable from './components/CryptoCurrenciesTable'
//import CryptoCurrencies from './components/crypto/CryptoCurrencies'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Card,
    Table,
    CryptoCurrenciesTable
//    CryptoCurrencies
  },
  data () {
    return {
      //
    }
  }
}
</script>
