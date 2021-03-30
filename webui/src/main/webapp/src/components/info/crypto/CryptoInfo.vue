<template>
    <div>
    </div>
</template>
<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'CryptoInfo',
        components: {
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('crypto', ['currencies', 'market']),
        },
        mounted() {
            this.fetchCurrencies();
            this.fetchMarketInfo();
        },
        methods: {
            ...mapActions('crypto', ['fetchCurrencies', 'fetchMarketInfo']),

        }
    }
</script>