<template>
    <v-container grid-list-md fluid>
        <v-layout row hidden-md-and-down>
            <Login></Login>
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
