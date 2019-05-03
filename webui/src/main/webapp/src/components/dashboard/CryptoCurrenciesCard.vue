<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card>
        <v-card-title class="indigo darken-1">
            <v-layout display-1 class="white--text">Crypto Currencies</v-layout>
        </v-card-title>
        <v-card-text>
            <v-data-table :headers="tableHeaders" :items="cryptoCurrencies">
                <template v-slot:items="props">
                    <td>{{ props.item.rank }}</td>
                    <td class="text-xs-right">{{ props.item.priceUSD }}</td>
                </template>
            </v-data-table>
        </v-card-text>
    </v-card>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CryptoCurrenciesCard',
        mounted: function() {
            this.$store.dispatch('CryptoCurrency/getAllCryptoCurrencies');
        },
        data: function() {
            return {
                tableHeaders: [
                    {
                        text: 'Rank',
                        align: 'left',
                        sortable: true,
                        value: 'rank'
                    },
                    {
                        text: 'Price (USD)',
                        aligh: 'left',
                        sortable: false,
                        value: 'priceUSD'
                    }
                ]
            }
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
