<template>
    <v-card>
        <v-card-title>
            <v-layout display-1>Login</v-layout>
        </v-card-title>
        <v-card-text>
            <v-form>
                <v-text-field
                        v-model="login"
                        prepend-icon="person"
                        label="Login"
                        required
                        :counter="50">
                </v-text-field>
                <v-text-field
                        v-model="password"
                        prepend-icon="lock"
                        label="Password"
                        required
                        :counter="50"
                        :append-icon="showPassword ? 'visibility_off' : 'visibility'"
                        :type="showPassword ? 'text' : 'password'"
                        @click:append="showPassword = !showPassword">
                </v-text-field>
            </v-form>
        </v-card-text>
        <v-card-actions>
            <v-btn v-on:click="doLogin">Login</v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    import axios from 'axios';

    export default {
        name: 'Login',
        data: function() {
            return {
                showPassword: false,
                login: '',
                password: ''
            };
        },
        methods: {
            doLogin: function() {
                const self = this;
                var bodyFormData = new FormData();
                bodyFormData.set('username', this.login);
                bodyFormData.set('password', this.password);
                axios({
                    method: 'post',
                    url: 'http://localhost:8080/login',
                    data: bodyFormData
                }).then(function(response) {
                    if (response.status === 200) {
                        self.$router.push({ name: 'dashboard'});
                    }
                });
            }
        }
    }
</script>

<style>

</style>
