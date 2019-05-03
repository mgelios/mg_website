<template>
    <v-card>
        <v-card-title class="teal darken-1">
            <v-layout display-1 class="white--text">Exhange Rates</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list>
                <template v-for="(item, index) in exchangeRates">
                    <v-list-tile :key="index">
                        <v-list-tile-content>
                            {{item.scale}} {{item.abbreviation}}
                        </v-list-tile-content>
                        <v-list-tile-action>
                            {{item.rate | byn}}
                        </v-list-tile-action>
                    </v-list-tile>
                    <v-divider v-if="index + 1 < exchangeRates.length" :key="index+'divider'"></v-divider>
                </template>
            </v-list>
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
