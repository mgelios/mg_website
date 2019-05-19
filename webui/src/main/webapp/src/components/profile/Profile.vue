<template>
    <v-container grid-list-md fluid>
        <v-layout row>
            <v-flex xs12 lg4>
            </v-flex>
            <v-flex xs12 lg4>
                <Login></Login>
            </v-flex>
            <v-flex xs12 lg4>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import Login from "./Login"

    export default {
        name: 'Profile',
        components: {
            Login
        }
    }
</script>

<style>

</style>
