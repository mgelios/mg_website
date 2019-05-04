<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card>
        <v-card-title class="indigo darken-1">
            <v-layout display-1 class="white--text">Crypto Currencies</v-layout>
        </v-card-title>
        <v-card-text>
            <v-data-table :headers="tableHeaders" :items="cryptoCurrencies">
                <template v-slot:items="props">
                    <td>{{ props.item.rank }}</td>
                    <td>{{ props.item.symbol}}</td>
                    <td>{{ props.item.priceUSD }}</td>
                    <td>{{ props.item.priceBTC }}</td>
                    <td>{{ props.item.percentChangeIn24h }}</td>
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
                        text: 'Symbol',
                        align: 'left',
                        sortable: true,
                        value: 'symbol'
                    },
                    {
                        text: 'Price (USD)',
                        align: 'left',
                        sortable: false,
                        value: 'priceUSD'
                    },
                    {
                        text: 'Price (BTC)',
                        align: 'left',
                        sortable: false,
                        value: 'priceBTC'
                    },
                    {
                        text: 'Change in 24h',
                        align: 'left',
                        sortable: true,
                        value: 'percentChangeIn24h'
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
