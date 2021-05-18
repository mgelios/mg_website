<template>
    <v-list-item>
        <v-list-item-content>
            <v-list-item-title>{{weatherForecastItemData.maxTemp | degreeCelsius}}</v-list-item-title>
            <v-list-item-subtitle>{{descriptionString()}}</v-list-item-subtitle>
        </v-list-item-content>
    </v-list-item>
</template>

<script>
    export default {
        name: 'WeatherForecastItem',
        props: {
            weatherForecastItemData: null,
        },
        methods: {

            descriptionString() {
                return Array.from(this.weatherForecastItemData.descriptions)
                    .sort((a,b) => {
                        return a > b ? 1 : -1;
                    })
                    .join(', ');
            }
        }
    }
</script>