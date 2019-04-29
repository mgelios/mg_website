<template>
    <v-card>
        <v-card-title>Crypto Market</v-card-title>
        <v-card-text>{{cryptoMarket}}</v-card-text>
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
