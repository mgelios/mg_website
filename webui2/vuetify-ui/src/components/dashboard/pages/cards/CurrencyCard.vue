<template>
    <v-card height="100%">
        <v-card-title class="teal darken-1">
            <v-layout headline class="white--text">Exhange Rates</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list>
                <template v-for="(item, index) in exchangeRates" :key="index">
                    <v-list-item>
                        <v-list-item-content>
                            {{item.scale}} {{item.abbreviation}}
                        </v-list-item-content>
                        <v-list-item-action>
                            {{item.rate | byn}}
                        </v-list-item-action>
                    </v-list-item>
                    <v-divider class="ma-0" v-if="index + 1 < exchangeRates.length" :key="index+'divider'"></v-divider>
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
