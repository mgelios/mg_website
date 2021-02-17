<template>
    <v-app>
        <ProfileSidebar v-bind:navigationDrawerActive="navigationDrawerActive">
        </ProfileSidebar>
        <v-app-bar app>
            <v-app-bar-nav-icon @click.native="navigationDrawerActive = !navigationDrawerActive"></v-app-bar-nav-icon>
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
            <router-view>

            </router-view>
        </v-main>
    </v-app>
</template>

<script>
    import { mapState, mapActions } from 'vuex';
    import { router } from "../../utils/router/router";
    import ProfileSidebar from "./ProfileSidebar";

    export default {
        name: 'Profile',
        components: {
            ProfileSidebar
        },
        data: () => ({
            router: router,
            navigationDrawerActive: true,
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
