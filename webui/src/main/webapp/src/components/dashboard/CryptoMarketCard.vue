<template>
    <v-card>
        <v-card-title class="indigo darken-1">
            <v-layout display-1 class="white--text">Crypto Market</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list-tile>
                <v-list-tile-content>Total USD:</v-list-tile-content>
                <v-list-tile-action>{{cryptoMarket.totalUsd}}</v-list-tile-action>
            </v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>
                <v-list-tile-content>USD volume in 24h:</v-list-tile-content>
                <v-list-tile-action>{{cryptoMarket.totalUsdDayVolume}}</v-list-tile-action>
            </v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>
                <v-list-tile-content>Number of active markets:</v-list-tile-content>
                <v-list-tile-action>{{cryptoMarket.activeMarkets}}</v-list-tile-action>
            </v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>
                <v-list-tile-content>Number of active currencies:</v-list-tile-content>
                <v-list-tile-action>{{cryptoMarket.activeCurrencies}}</v-list-tile-action>
            </v-list-tile>
            <v-divider></v-divider>
            <v-list-tile>
                <v-list-tile-content>Bitcoin percentage:</v-list-tile-content>
                <v-list-tile-action>{{cryptoMarket.bitcoinPercent}}%</v-list-tile-action>
            </v-list-tile>
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
