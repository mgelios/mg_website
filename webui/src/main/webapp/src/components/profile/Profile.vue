<template>
    <v-container fluid fill-height>
        <v-layout align-center justify-center>
            <v-flex xs12 sm8 md4>
                <Login></Login>
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
