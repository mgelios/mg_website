<template>
    <v-app>
        <v-app-bar app flat>
            <v-app-bar-nav-icon @click.native="navDrawer = !navDrawer"></v-app-bar-nav-icon>
            <div class="flex-grow-1"></div>
            <v-menu v-model="menu" :close-on-content-click="false">
                <template v-slot:activator="{ on }">
                    <v-btn icon v-on="on">
                        <v-icon>business</v-icon>
                    </v-btn>
                </template>
                <v-card>
                    <v-list>
                        <v-list-item @click="router.push({name: pages.Dashboard.Main})">
                            <v-list-item-avatar>
                                <v-icon>dashboard</v-icon>
                            </v-list-item-avatar>
                            <v-list-item-content>
                                <v-list-item-title>Dashboard</v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list>
                </v-card>
            </v-menu>
            <router-link :to="{ name: 'profile' }"><v-icon large>perm_identity</v-icon></router-link>
        </v-app-bar>
        <v-navigation-drawer v-model="navDrawer" app absolute left>
            <template v-slot:prepend>
                <v-list-item two-line>
                    <v-list-item-avatar>
                        <v-icon x-large>chrome_reader_mode</v-icon>
                    </v-list-item-avatar>
                    <v-list-item-content>
                        <v-list-item-title>Blog</v-list-item-title>
                        <v-list-item-subtitle>blog status here...</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </template>
            <v-divider></v-divider>
            <v-list dense>
                <v-list-item
                        v-for="item in items"
                        :key="item.title">
                    <v-list-item-icon>
                        <v-icon>{{ item.icon }}</v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title>{{ item.title }}</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>
        <router-view>
        </router-view>
    </v-app>
</template>

<script>
    import router from "@/router";
    import { pages } from "@/router/pages";

    export default {
        name: 'Blog',
        data () {
            return {
                menu: false,
                router: router,
                pages: pages,
                navDrawer: true,
                items: [
                    { title: 'Home', icon: 'mdi-home-city' },
                    { title: 'My Account', icon: 'mdi-account' },
                    { title: 'Users', icon: 'mdi-account-group-outline' },
                ],
            }
        }
    }
</script>

<style>

</style>
