<template>
    <v-card height="100%">
        <v-card-title class="teal darken-1">
            <v-layout headline class="white--text">CurrencyModel Conversions</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list>
                <template v-for="(item, index) in conversions">
                    <v-list-item :key="index">
                        <v-list-item-content>
                            {{item.currencyFrom.abbreviation}}/{{item.currencyTo.abbreviation}}
                        </v-list-item-content>
                        <v-list-item-action>
                            {{item.value}}
                        </v-list-item-action>
                    </v-list-item>
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
