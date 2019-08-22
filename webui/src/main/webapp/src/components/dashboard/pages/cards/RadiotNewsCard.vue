<template>
    <v-card>
        <v-card-title class="light-blue darken-2">
            <v-layout headline class="white--text">Radiot Articles</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list>
                <template v-for="(item, index) in articles">
                    <v-list-item :key="index" v-if="index < 6">
                        <v-list-item-avatar v-if="item.mainPicture">
                            <img :src="item.mainPicture">
                        </v-list-item-avatar>
                        <v-list-item-content>
                            <v-list-item-title>{{item.title}}</v-list-item-title>
                            <v-list-item-subtitle>{{item.snippet}}</v-list-item-subtitle>
                        </v-list-item-content>
                        <v-list-item-action>
                            <v-btn icon ripple :href="item.link" :exact="true">
                                <v-icon color="grey lighten-1">play_arrow</v-icon>
                            </v-btn>
                        </v-list-item-action>
                    </v-list-item>
                    <v-divider v-if="index < 5" :key="index+'divider'"></v-divider>
                </template>
            </v-list>
        </v-card-text>
    </v-card>
</template>

<script>
    import { mapState } from 'vuex';

    export default {
        name: 'RadiotNewsCard',
        mounted: function() {
            this.$store.dispatch('Radiot/getArticles');
        },
        computed: {
            ...mapState({
                articles : state => state.Radiot.articles
            })
        }
    }
</script>

<style>

</style>
