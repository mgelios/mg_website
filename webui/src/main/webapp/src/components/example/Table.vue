<template>
<div>
    <v-data-table :headers="headers" :items="items">
      <template v-slot:items="props">
        <td>{{ props.item.cityName }}</td>
        <td class="text-xs-right">{{ props.item.temperature }}</td>
      </template>
    </v-data-table>
    <v-flex xs12 lg6>
        <ExampleChart
            v-if="items.length !== 0"
            :chartdata="items">
        </ExampleChart>
    </v-flex>
</div>
</template>

<script>
    import ExampleChart from './ExampleChart';
    import { mapState } from 'vuex';

    export default {
        name: 'Table',
        components: {
            ExampleChart
        },
        data: function() {
            return {
                headers: [
                    {
                        text: 'city name',
                        align: 'left',
                        sortable: false,
                        value: 'cityName'
                    },
                    {
                        text: 'temperature',
                        aligh: 'left',
                        sortable: false,
                        value: 'temperature'
                    }
                ]
            }
        },
        mounted: function() {
            this.$store.dispatch('Weather/getWeatherForecast');
        },
        computed: {
            ...mapState({
                items : state => state.Weather.weatherForecast
            })
        }
    }
</script>

<style>

</style>
