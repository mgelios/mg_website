<template>
    <v-app>
        <AdminSidebar
                v-bind:navigationDrawerActive.sync="navigationDrawerActive"
                v-on:toggled="setNavigationDrawer"
        />
        <v-app-bar app>
            <v-app-bar-nav-icon @click.native="setNavigationDrawer(!navigationDrawerActive)"></v-app-bar-nav-icon>
            <v-toolbar-title>Admin</v-toolbar-title>
            <div class="flex-grow-1"></div>
            <v-btn
                    v-if="!appData || !appData.authToken"
                    elevation="2"
                    @click="router.push({name: pages.Profile.Login})">
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
    import router from "@/router";
    import { pages } from "@/router/pages";
    import AdminSidebar from "./AdminSidebar";

    export default {
        name: 'Admin',
        components: {
            AdminSidebar
        },
        data: () => ({
            router: router,
            pages: pages,
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
            },

            setNavigationDrawer: function(value) {
                this.navigationDrawerActive = value;
            }
        }
    }
</script>

<style>

</style>
