<template>
    <div>
        {{currencyRates}}
        {{currencyConversions}}
        {{currencyStatistics}}
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
            ...mapState('currency', ['currencyRates', 'currencyConversions', 'currencyStatistics']),
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