<template>
    <v-navigation-drawer app v-model="navigationDrawerActive">
        <v-divider></v-divider>
        <v-list dense nav>
            <v-list-item link @click="router.push({ name: 'profile' })">
                <v-list-item-content>
                    <v-list-item-content>Profile root</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
            <v-list-item link @click="router.push({ name: 'admin' })">
                <v-list-item-content>
                    <v-list-item-content>Admin root</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
            <v-list-item link @click="router.push({ name: 'apiConsumer' })">
                <v-list-item-content>
                    <v-list-item-content>Api consumer</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
            <v-list-item link @click="router.push({ name: 'addApiConsumer' })">
                <v-list-item-content>
                    <v-list-item-content>Add api consumer</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
    import { router } from "../../utils/router/router";

    export default {
        name: 'AdminSidebar',
        components: {
        },
        props: {
            navigationDrawerActive: {
                default: true,
            }
        },
        data: () => ({
            router: router,
        })
    }
</script>