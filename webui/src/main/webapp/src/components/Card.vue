<template>
    <v-card>
        <v-card-title>
          <h2>{{cardContent.cityName | capitalize}}: {{cardContent.description}}, {{cardContent.temperature | degree}}</h2>
        </v-card-title>
        <v-card-text>{{cardContent.mainInfo}}</v-card-text>
    </v-card>
</template>

<script>
  import axios from 'axios';
  export default {
    name: 'Card',
    data: function() {
        return {
            cardTitle: "Some card title",
            cardContent: ""
        }
    },
    mounted: function() {
      axios
        .get("http://localhost:8080/api/v1/weather/current")
        .then(response => {
          this.cardContent = response.data;
        });

    },
    filters: {
      capitalize: function(string) {
        if (!string)
          return '';
        string = string.toString();
        return string.charAt(0).toUpperCase() + string.slice(1);
      },
      degree: function(value) {
        var string = "";
        if (!value) return '';
        if (value > 0) {
          string = "+";
        } else if (value < 0) {
          string = "-";
        } 
        string = string + value.toString() + "°C";
        return string;
      }
    }
  }
</script>

<style>

</style>
