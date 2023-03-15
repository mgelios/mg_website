<template>
    <div>
        {{currencyRates}}
        {{monthlyCurrencyStatisticsUsd}}
    </div>
</template>
<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'CurrencyInfo',
        components: {
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('currency', [
                'currencyRates',
                'currencyConversions',
                'annualCurrencyStatisticsUsd',
                'annualCurrencyStatisticsEur',
                'monthlyCurrencyStatisticsEur',
                'monthlyCurrencyStatisticsUsd',
            ]),
        },
        mounted() {
            this.fetchExchangeRates();
            this.fetchCurrencyConversions();
            this.fetchCurrencyStatistics();
        },
        methods: {
            ...mapActions('currency', ['fetchExchangeRates', 'fetchCurrencyConversions', 'fetchCurrencyStatistics']),

        }
    }
</script>