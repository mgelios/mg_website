<template>
    <v-app>
        <v-app-bar app flat>
            <v-app-bar-nav-icon @click.native="navDrawer = !navDrawer"></v-app-bar-nav-icon>
            <div class="flex-grow-1"></div>
            <v-menu
                    v-model="menu"
                    :close-on-content-click="false">
                <template v-slot:activator="{ on }">
                    <v-btn icon v-on="on">
                        <v-icon>business</v-icon>
                    </v-btn>
                </template>
                <v-card>
                    <v-list>
                        <v-list-item @click="router.push({name: pages.Blog.Main})">
                            <v-list-item-avatar>
                                <v-icon>chrome_reader_mode</v-icon>
                            </v-list-item-avatar>
                            <v-list-item-content>
                                <v-list-item-title>Blog</v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list>
                </v-card>
            </v-menu>
            <v-icon large @click="router.push({name: pages.Profile.Login })">perm_identity</v-icon>
            <v-icon large @click="router.push({name: pages.Profile.Main })">perm_identity</v-icon>
            <!--<HelloWorld/>-->
        </v-app-bar>

        <v-navigation-drawer
                app
                v-model="navDrawer">
            <v-list>
                <v-list-item avatar>
                    <v-list-item-avatar>
                        <v-icon x-large @click="router.push({name: pages.Dashboard.Main })">dashboard</v-icon>
                    </v-list-item-avatar>
                    <v-list-item-content>
                        <v-list-item-title>Dashboard</v-list-item-title>
                    </v-list-item-content>
                    <v-list-item-action>
                        <v-btn icon @click.stop="miniToolbar = !miniToolbar">
                            <v-icon>chevron_left</v-icon>
                        </v-btn>
                    </v-list-item-action>
                </v-list-item>
            </v-list>
            <v-list>
                <v-list-item
                        v-for="navItem in navigationItems"
                        :key="navItem.title"
                        @click="router.push({name: navItem.route})">
                    <v-list-item-action>
                        <v-icon>{{navItem.icon}}</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title>{{navItem.title}}</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>

        <router-view></router-view>

        <v-footer
                app
                :inset="true"
                :fixed="false"
                class="justify-center">
            &copy;MGeliOS 2023
        </v-footer>
    </v-app>
</template>

<script>
    import router from "@/router";
    import { pages } from "@/router/pages";

    export default {
        name: 'Dashboard',
        data: function () {
            return {
                router: router,
                pages: pages,
                menu: false,
                navDrawer: true,
                miniToolbar: true,
                navigationItems: [
                    {
                        title: 'Weather',
                        icon: 'cloud',
                        route: pages.Dashboard.Weather
                    },
                    {
                        title: 'Finance',
                        icon: 'euro_symbol',
                        route: pages.Dashboard.Finance
                    },
                    {
                        title: 'Crypto market',
                        icon: 'list_alt',
                        route: pages.Dashboard.Crypto
                    },
                    {
                        title: 'Radio-T',
                        icon: 'radio',
                        route: ''
                    },
                ]
            }
        },
    }
</script>

<style>

</style>
