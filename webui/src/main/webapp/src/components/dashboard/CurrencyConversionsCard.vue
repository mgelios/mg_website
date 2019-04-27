<template>
    <v-card>
        <v-card-title>
            <v-layout display-1>Currency Conversions</v-layout>
        </v-card-title>
        <v-card-text>
            {{conversions}}
        </v-card-text>
    </v-card>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CurrencyConversionCard',
        mounted: function() {
            this.$store.dispatch('Currency/getCurrencyConversions');
        },
        computed: {
            ...mapState({
                conversions : state => state.Currency.conversions
            })
        }
    }
</script>

<style>

</style>
