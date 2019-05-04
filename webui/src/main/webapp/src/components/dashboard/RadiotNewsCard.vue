<template>
    <v-card>
        <v-card-title class="light-blue darken-2">
            <v-layout display-1 class="white--text">Radiot Articles</v-layout>
        </v-card-title>
        <v-card-text>
            <v-list>
                <template v-for="(item, index) in articles">
                    <v-list-tile :key="index" v-if="index < 6">
                        <v-list-tile-avatar v-if="item.mainPicture">
                            <img :src="item.mainPicture">
                        </v-list-tile-avatar>
                        <v-list-tile-content>
                            <v-list-tile-title>{{item.title}}</v-list-tile-title>
                            <v-list-tile-sub-title>{{item.snippet}}</v-list-tile-sub-title>
                        </v-list-tile-content>
                        <v-list-tile-action>
                            <v-btn icon ripple :href="item.link" :exact="true">
                                <v-icon color="grey lighten-1">play_arrow</v-icon>
                            </v-btn>
                        </v-list-tile-action>
                    </v-list-tile>
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
