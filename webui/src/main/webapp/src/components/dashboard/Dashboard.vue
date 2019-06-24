<template>
    <div>
        <v-navigation-drawer app v-model="navDrawer" :mini-variant.sync="miniToolbar">
            <v-toolbar flat>
                <v-list>
                    <v-list-tile avatar>
                        <v-list-tile-avatar>
                            <v-icon x-large>dashboard</v-icon>
                        </v-list-tile-avatar>
                        <v-list-tile-content>
                            <v-list-tile-title>Dashboard</v-list-tile-title>
                        </v-list-tile-content>
                        <v-list-tile-action>
                            <v-btn icon @click.stop="miniToolbar = !miniToolbar">
                                <v-icon>chevron_left</v-icon>
                            </v-btn>
                        </v-list-tile-action>
                    </v-list-tile>
                </v-list>
            </v-toolbar>
            <v-list>
                <v-list-tile
                        v-for="navItem in navigationItems"
                        :key="navItem.title">
                    <v-list-tile-action>
                        <v-icon>{{navItem.icon}}</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>{{navItem.title}}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-navigation-drawer>
        <v-toolbar app flat>
            <v-toolbar-side-icon @click.native="navDrawer = !navDrawer"></v-toolbar-side-icon>
            <router-link :to="{ name: 'profile' }"><v-icon large>perm_identity</v-icon></router-link>
            <!--<HelloWorld/>-->
        </v-toolbar>
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
                        route: ''
                    },
                    {
                        title: 'Finance',
                        icon: 'euro_symbol',
                        route: ''
                    },
                    {
                        title: 'Crypto market',
                        icon: 'list_alt',
                        route: ''
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