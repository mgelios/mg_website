<template>
    <v-app>
        <div class="d-flex align-center flex-column">
            <v-card width="600">
                <v-card-title>
                    <v-layout display-1>Login</v-layout>
                </v-card-title>
                <v-card-text>
                    <v-form>
                        <v-text-field
                                v-model="username"
                                prepend-icon="mdi-account"
                                label="Username"
                                required
                                :counter="50">
                        </v-text-field>
                        <v-text-field
                                v-model="password"
                                prepend-icon="mdi-key"
                                label="Password"
                                required
                                :counter="50"
                                :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                                :type="showPassword ? 'text' : 'password'"
                                @click:append="showPassword = !showPassword">
                        </v-text-field>
                    </v-form>
                </v-card-text>
                <v-card-actions>
                    <v-btn
                        v-on:click="doLogin"
                        block
                        variant="flat"
                        color="amber-lighten-1">Login</v-btn>
                </v-card-actions>
            </v-card>
        </div>
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
