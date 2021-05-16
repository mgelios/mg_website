<template>
    <v-list-item>
        <v-list-item-content>
            <v-list-item-title>{{weatherForecastItemData.maxTemp | degreeCelsius}}</v-list-item-title>
            <v-list-item-subtitle>{{weatherForecastItemData.date.value.getDate()}}</v-list-item-subtitle>
        </v-list-item-content>
    </v-list-item>
</template>

<script>
    export default {
        name: 'WeatherForecastItem',
        props: {
            weatherForecastItemData: null,
        }
    }
</script>