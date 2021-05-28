<template>
    <div>
        {{currencyRates}}
    </div>
</template>
<script>
    import { mapState, mapActions, mapGetters } from 'vuex';

    export default {
        name: 'CurrencyInfo',
        components: {
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('currency', ['currencyRates', 'currencyConversions', 'currencyStatisticsUsd', 'currencyStatisticsEur']),
            ...mapGetters('currency', ['statisticsUsd', 'statisticsEur']),
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