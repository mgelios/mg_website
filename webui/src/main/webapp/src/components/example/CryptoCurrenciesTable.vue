<template>
    <v-data-table :headers="headers" :items="cryptoCurrencies">
        <template v-slot:items="cryptoCurrencies">
            <td>{{ cryptoCurrencies.item.rank }}</td>
            <td>{{ cryptoCurrencies.item.name }}</td>
            <td>{{ cryptoCurrencies.item.symbol }}</td>
            <td>{{ cryptoCurrencies.item.priceUSD }}</td>
            <td>{{ cryptoCurrencies.item.priceBTC }}</td>
            <td>{{ cryptoCurrencies.item.percentChangeIn24h }}</td>
        </template>
    </v-data-table>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'CryptoCurrenciesTable',
        data: function() {
            return {
                headers: [
                    {
                        text: 'Rank',
                        align: 'left',
                        sortable: true,
                        value: 'rank'
                    },
                    {
                        text: 'Name',
                        align: 'left',
                        sortable: true,
                        value: 'name'
                    },
                    {
                        text: 'Symbol',
                        aligh: 'left',
                        sortable: true,
                        value: 'symbol'
                    },
                    {
                        text: 'Price (USD)',
                        aligh: 'left',
                        sortable: true,
                        value: 'priceUSD'
                    },
                    {
                        text: 'Price (BTC)',
                        aligh: 'left',
                        sortable: true,
                        value: 'priceBTC'
                    },
                    {
                        text: 'Сhange in 24h',
                        aligh: 'left',
                        sortable: true,
                        value: 'percentChangeIn24h'
                    }
                ]
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