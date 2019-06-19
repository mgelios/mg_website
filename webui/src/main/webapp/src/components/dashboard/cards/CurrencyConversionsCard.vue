<template>
    <v-card>
        <v-card-title class="teal darken-1">
            <v-layout headline class="white--text">Currency Conversions</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list>
                <template v-for="(item, index) in conversions">
                    <v-list-tile :key="index">
                        <v-list-tile-content>
                            {{item.currencyFrom.abbreviation}}/{{item.currencyTo.abbreviation}}
                        </v-list-tile-content>
                        <v-list-tile-action>
                            {{item.value}}
                        </v-list-tile-action>
                    </v-list-tile>
                    <v-divider class="ma-0" v-if="index + 1 < conversions.length" :key="index+'divider'"></v-divider>
                </template>
            </v-list>
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
