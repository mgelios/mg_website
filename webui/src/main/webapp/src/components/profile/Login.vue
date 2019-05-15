<template>
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
</template>

<script>
    export default {
        name: 'Login'
    }
</script>

<style>

</style>
