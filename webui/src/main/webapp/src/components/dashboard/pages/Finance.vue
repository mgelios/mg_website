<template>
    <v-content>
        <v-container fluid grid-list-md>
            <v-card>
                <v-card-text>
                    <v-layout row wrap>
                        <v-flex xs12 lg6>
                            <p class="text-xs-center headline">Conversions</p>
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
                        </v-flex>
                        <v-flex xs12 lg6>
                            <p class="text-xs-center headline">Exhange Rates</p>
                            <v-list>
                                <template v-for="(item, index) in exchangeRates">
                                    <v-list-item :key="index">
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
                        </v-flex>
                    </v-layout>
                    <v-layout row wrap>
                        <v-flex xs12 lg6>
                            <p class="text-xs-center headline">USD month rates</p>
                            <FinanceChart v-if="statisticsUSD.length != 0"
                                          :chartData="statisticsUSD"
                                          :chartLabel="usdLabel"
                                          :aspectRatio="usdAspectRatio">
                            </FinanceChart>
                        </v-flex>
                        <v-flex xs12 lg6>
                            <p class="text-xs-center headline">EUR month rates</p>
                            <FinanceChart v-if="statisticsEUR.length != 0"
                                          :chartData="statisticsEUR"
                                          :chartLabel="eurLabel"
                                          :aspectRatio="eurAspectRatio">
                            </FinanceChart>
                        </v-flex>
                    </v-layout>
                </v-card-text>
            </v-card>
        </v-container>
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
            this.$store.dispatch('Currency/getExchangeRates');
            this.$store.dispatch('Currency/getCurrencyConversions');
        },
        computed: {
            ...mapState({
                statisticsEUR : state => state.Currency.statisticsEUR,
                statisticsUSD : state => state.Currency.statisticsUSD,
                conversions : state => state.Currency.conversions,
                exchangeRates : state => state.Currency.rates
            })
        }
    }
</script>

<style>

</style>
