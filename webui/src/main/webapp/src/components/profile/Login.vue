<template>
    <v-card>
        <v-card-title>
            <v-layout display-1>Login</v-layout>
        </v-card-title>
        <v-card-text>
            <v-form>
                <v-text-field
                        label="Login"
                        required
                        :counter="50"></v-text-field>
                <v-text-field
                        label="Password"
                        required
                        :counter="50"></v-text-field>
            </v-form>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: 'Login'
    }
</script>

<style>

</style>
