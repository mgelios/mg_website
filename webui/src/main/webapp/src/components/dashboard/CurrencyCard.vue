<template>
    <v-card>
        <v-card-title>
            <v-layout display-1>Exhange Rates</v-layout>
        </v-card-title>
        <v-card-text>
            {{exchangeRates}}
        </v-card-text>
    </v-card>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CurrencyCard',
        mounted: function() {
            this.$store.dispatch('Currency/getExchangeRates');
        },
        computed: {
            ...mapState({
                exchangeRates : state => state.Currency.rates
            })
        }
    }
</script>

<style>

</style>
