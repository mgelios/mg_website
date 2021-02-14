<template>
    <v-app>
        <v-navigation-drawer app v-model="navigationDrawerActive">

        </v-navigation-drawer>
        <v-app-bar app>
            <v-app-bar-nav-icon @click="navigationDrawerActive = !navigationDrawerActive"></v-app-bar-nav-icon>
            <v-toolbar-title>Profile</v-toolbar-title>
            <div class="flex-grow-1"></div>
            <v-btn
                    v-if="!appData || !appData.authToken"
                    elevation="2"
                    @click="router.push({name: 'login'})">
                Login
            </v-btn>
            <v-btn
                    v-if="appData && appData.authToken"
                    elevation="2"
                    @click="handleLogoutClick">
                Log out
            </v-btn>
        </v-app-bar>
        <v-main>

        </v-main>
    </v-app>
</template>

<script>
    import { mapState, mapActions } from 'vuex';
    import { router } from "../../utils/router/router";

    export default {
        name: 'Profile',
        components: {
        },
        data: () => ({
            router: router,
            navigationDrawerActive: false,
        }),
        computed: {
            ...mapState('profile', ['activeProfile']),
            ...mapState('app', ['appData']),
        },
        methods: {
            ...mapActions('profile', ['performLogout']),
            handleLogoutClick: function() {
                this.performLogout();
            }
        }
    }
</script>

<style>

</style>
