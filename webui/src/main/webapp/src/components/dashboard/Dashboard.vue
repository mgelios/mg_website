<template>
    <div>
        <v-navigation-drawer app v-model="navDrawer" :mini-variant.sync="miniToolbar">
                <v-list>
                    <v-list-item avatar>
                        <v-list-item-avatar>
                            <router-link :to="{ name: 'dashboardMainPage' }">
                                <v-icon x-large>dashboard</v-icon>
                            </router-link>
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
                        :key="navItem.title">
                        <v-list-item-action>
                            <router-link :to="{ name: navItem.route }">
                                <v-icon>{{navItem.icon}}</v-icon>
                            </router-link>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title>{{navItem.title}}</v-list-item-title>
                        </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>
        <v-app-bar app flat>
            <v-app-bar-nav-icon @click.native="navDrawer = !navDrawer"></v-app-bar-nav-icon>
            <div class="flex-grow-1"></div>
            <router-link :to="{ name: 'profile' }"><v-icon large>perm_identity</v-icon></router-link>
            <!--<HelloWorld/>-->
        </v-app-bar>
            <router-view></router-view>
        <v-footer app :inset="true" :fixed="false" class="justify-center">&copy;MGeliOS 2019</v-footer>
    </div>
</template>

<script>
    export default {
        name: 'Dashboard',
        data: function () {
            return {
                navDrawer: true,
                miniToolbar: true,
                navigationItems: [
                    {
                        title: 'Weather',
                        icon: 'cloud',
                        route: 'dashboardWeatherPage'
                    },
                    {
                        title: 'Finance',
                        icon: 'euro_symbol',
                        route: 'dashboardFinancePage'
                    },
                    {
                        title: 'Crypto market',
                        icon: 'list_alt',
                        route: 'dashboardCryptoMarketPage'
                    },
                    {
                        title: 'Radio-T',
                        icon: 'radio',
                        route: ''
                    },
                ]
            }
        }
    }
</script>

<style>

</style>