<template>
    <v-card>
        <v-card-title class="indigo darken-1">
            <v-layout display-1 class="white--text">Crypto Market</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list-tile>Total USD: {{cryptoMarket.totalUsd}}</v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>USD volume in 24h: {{cryptoMarket.totalUsdDayVolume}}</v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>Number of active markets: {{cryptoMarket.activeMarkets}}</v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>Number of active currencies: {{cryptoMarket.activeCurrencies}}</v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>Bitcoin percentage: {{cryptoMarket.bitcoinPercent}}%</v-list-tile>
        </v-card-text>
    </v-card>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CryptoMarketCard',
        mounted: function() {
            this.$store.dispatch('CryptoCurrency/getCryptoMarket');
        },
        computed: {
            ...mapState({
                cryptoMarket : state => state.CryptoCurrency.market
            })
        }
    }
</script>

<style>

</style>
