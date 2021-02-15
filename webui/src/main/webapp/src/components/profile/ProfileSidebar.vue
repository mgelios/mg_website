<template>
    <v-navigation-drawer app v-model="navigationDrawerActive">
        <v-divider></v-divider>
    </v-navigation-drawer>
</template>

<script>
    export default {
        name: 'ProfileSidebar',
        components: {
        },
        props: {
            navigationDrawerActive: {
                default: true,
            }
        },
        data: () => ({

        })
    }
</script>