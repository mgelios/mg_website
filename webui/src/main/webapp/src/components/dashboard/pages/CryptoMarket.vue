<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-content>
        <v-container fluid grid-list-md>
            <v-card>
                <v-card-text>
                    <v-data-table :headers="tableHeaders" :items="cryptoCurrencies" :pagination.sync="defaultPagination">
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
        </v-container>
    </v-content>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CryptoMarket',
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
                ],
                defaultPagination: {
                    rowsPerPage: -1
                }
            }
        },
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
