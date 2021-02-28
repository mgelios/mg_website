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

            <v-list-item link @click="router.push({ name: pages.Info.Weather })">
                <v-list-item-content>
                    <v-list-item-content>Weather</v-list-item-content>
                </v-list-item-content>
            </v-list-item>
        </v-list>
    </v-navigation-drawer>

</template>
<script>
    import { router } from "../../utils/router/router";
    import { pages } from "../../utils/router/pages";

    export default {
        name: 'InfoSidebar',
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
        },
    }
</script>