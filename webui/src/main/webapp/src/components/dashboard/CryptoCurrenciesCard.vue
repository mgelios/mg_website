<template>
    <v-card>
        <v-card-title>Crypto Currencies</v-card-title>
        <v-card-text>{{cryptoCurrencies}}</v-card-text>
    </v-card>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CryptoCurrenciesCard',
        mounted: function() {
            this.$store.dispatch('CryptoCurrency/getAllCryptoCurrencies');
        },
        computed: {
            ...mapState({
                cryptoCurrencies : state => state.CryptoCurrency.all
            })
        }
    }
</script>

<style>

</style>
