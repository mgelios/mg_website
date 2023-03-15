<template>
    <v-navigation-drawer app v-model="navigationActive" v-on:input="handleInputEvent">
        <v-divider></v-divider>
        <v-list dense nav>
            <v-list-item link @click="router.push({ name: pages.Profile.Main })">
                <v-list-item-content>
                    <v-list-item-content>Profile root</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
            <v-list-item link @click="router.push({ name: pages.Admin.Main })">
                <v-list-item-content>
                    <v-list-item-content>Admin root</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
            <v-list-item link @click="router.push({ name: pages.Admin.ApiConsumerMain })">
                <v-list-item-content>
                    <v-list-item-content>Api consumer</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
            <v-list-item link @click="router.push({ name: pages.Admin.ApiConsumerAdd })">
                <v-list-item-content>
                    <v-list-item-content>Add api consumer</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
            <v-list-item link @click="router.push({ name: pages.Info.Main })">
                <v-list-item-content>
                    <v-list-item-content>Info root</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
    import router from "@/router";
    import { pages } from "@/router/pages";

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
            pages: pages,
        }),
        computed: {
            navigationActive: {
                get() {
                    return this.navigationDrawerActive;
                },
                set() {}
            }
        },
        methods: {
            handleInputEvent: function(value) {
                this.$emit('toggled', value);
            }
        }
    }
</script>
