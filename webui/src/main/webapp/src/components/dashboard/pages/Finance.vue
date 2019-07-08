<template>
    <v-content>
        <v-card>
            <v-card-text>
                <v-layout row wrap>
                    <v-flex xs12 lg6 d-flex>
                        <FinanceChart v-if="statisticsUSD.length != 0"
                                      :chartData="statisticsUSD"
                                      :chartLabel="usdLabel"
                                      :aspectRatio="usdAspectRatio">
                        </FinanceChart>
                    </v-flex>
                    <v-flex xs12 lg6 d-flex>
                        <FinanceChart v-if="statisticsEUR.length != 0"
                                      :chartData="statisticsEUR"
                                      :chartLabel="eurLabel"
                                      :aspectRatio="eurAspectRatio">
                        </FinanceChart>
                    </v-flex>
                </v-layout>
            </v-card-text>
        </v-card>
    </v-content>
</template>

<script>
    import { mapState } from 'vuex';
    import FinanceChart from './charts/FinanceChart';

    export default {
        name: 'Finance',
        data: function() {
            return {
                usdAspectRatio: 2.2,
                usdLabel: 'USD',
                eurAspectRatio: 2.2,
                eurLabel: 'EUR',
            }
        },
        components: {
            FinanceChart
        },
        mounted: function() {
            this.$store.dispatch('Currency/getCurrenciesStatistics');
        },
        computed: {
            ...mapState({
                statisticsEUR : state => state.Currency.statisticsEUR,
                statisticsUSD : state => state.Currency.statisticsUSD
            })
        }
    }
</script>

<style>

</style>
