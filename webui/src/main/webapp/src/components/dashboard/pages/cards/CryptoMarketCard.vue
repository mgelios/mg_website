<template>
    <v-card>
        <v-card-title class="indigo darken-1">
            <v-layout headline class="white--text">Crypto Market</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list-item>
                <v-list-item-content>Total USD:</v-list-item-content>
                <v-list-item-action>{{cryptoMarket.totalUsd}}</v-list-item-action>
            </v-list-item>
            <v-divider></v-divider>
            <v-list-item>
                <v-list-item-content>USD volume in 24h:</v-list-item-content>
                <v-list-item-action>{{cryptoMarket.totalUsdDayVolume}}</v-list-item-action>
            </v-list-item>
            <v-divider></v-divider>
            <v-list-item>
                <v-list-item-content>Number of active markets:</v-list-item-content>
                <v-list-item-action>{{cryptoMarket.activeMarkets}}</v-list-item-action>
            </v-list-item>
            <v-divider></v-divider>
            <v-list-item>
                <v-list-item-content>Number of active currencies:</v-list-item-content>
                <v-list-item-action>{{cryptoMarket.activeCurrencies}}</v-list-item-action>
            </v-list-item>
            <v-divider></v-divider>
            <v-list-item>
                <v-list-item-content>Bitcoin percentage:</v-list-item-content>
                <v-list-item-action>{{cryptoMarket.bitcoinPercent}}%</v-list-item-action>
            </v-list-item>
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
