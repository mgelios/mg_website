<template>
  <div></div>
</template>

<script>
  import axios from 'axios';
  export default {
    name: 'CryptoCurrencies',
    data: function() {
        return {

        }
    },
    mounted: function() {
        this.$root.$on('cryptoCurrenciesUpdateRequred', () => {
            var items;
            axios
                .get("http://localhost:8080/api/v1/weather/forecast")
                .then(response => {
                    items = response.data;
                });
                return items;
        });
    }
  }
</script>

<style>
</style>
