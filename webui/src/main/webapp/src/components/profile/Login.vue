<template>
    <v-app>
        <v-container fluid fill-height>
            <v-layout align-center justify-center>
                <v-flex xs12 sm8 md4>
                    <v-card>
                        <v-card-title>
                            <v-layout display-1>Login</v-layout>
                        </v-card-title>
                        <v-card-text>
                            <v-form>
                                <v-text-field
                                        v-model="username"
                                        prepend-icon="person"
                                        label="Username"
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
                </v-flex>
            </v-layout>
        </v-container>
    </v-app>
</template>

<script>
    import { mapActions } from 'vuex';

    export default {
        name: 'Login',
        data: function() {
            return {
                showPassword: false,
                username: '',
                password: ''
            };
        },
        methods: {
            ...mapActions('profile', ['performLogin']),

            doLogin() {
                this.performLogin({
                    username: this.username,
                    password: this.password,
                });
            }
        }
    }
</script>

<style>

</style>
