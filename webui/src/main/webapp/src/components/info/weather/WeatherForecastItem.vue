<template>
    <v-list-item>
        <v-list-item-content>
            <v-list-item-title>
                {{weatherForecastItemData.date.value.toDateString()}}:
            </v-list-item-title>
            <v-list-item-subtitle>
                {{descriptionString()}}
            </v-list-item-subtitle>
            <v-list-item-subtitle>
                Pressure: {{weatherForecastItemData.minPressure}} hpa .. {{weatherForecastItemData.maxPressure}} hpa,
            </v-list-item-subtitle>
            <v-list-item-subtitle>
                Windspeed: {{weatherForecastItemData.minWindSpeed}} kmh .. {{weatherForecastItemData.maxWindSpeed}} kmh
            </v-list-item-subtitle>
        </v-list-item-content>
        <v-list-item-action>
            {{weatherForecastItemData.minTemp | degreeCelsius}} .. {{weatherForecastItemData.maxTemp | degreeCelsius}}
            <v-list-item-action-text>
                feels like: {{weatherForecastItemData.minFeelsLike | degreeCelsius}} .. {{weatherForecastItemData.maxFeelsLike | degreeCelsius}}
            </v-list-item-action-text>
        </v-list-item-action>
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