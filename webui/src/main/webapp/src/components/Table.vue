<template>
<div>
    <v-data-table :headers="headers" :items="items">
      <template v-slot:items="props">
        <td>{{ props.item.cityName }}</td>
        <td class="text-xs-right">{{ props.item.temperature }}</td>
      </template>
    </v-data-table>
</div>
</template>

<script>
  import axios from 'axios';

  export default {
    name: 'Table',
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
            ],
            items: []
        }
    },
    mounted: function() {
      axios
        .get("http://localhost:8080/api/v1/weather/forecast")
        .then(response => {
          this.items = response.data;
        });
    }
  }
</script>

<style>

</style>
