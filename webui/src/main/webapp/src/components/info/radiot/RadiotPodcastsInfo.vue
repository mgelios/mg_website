<template>
    <div>
        {{articles}}
    </div>
</template>
<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'RadiotPodcastsInfo',
        components: {
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('radio-t/podcast', ['podcasts']),
        },
        mounted() {
            this.fetchArticles();
        },
        methods: {
            ...mapActions('radio-t/podcast', ['fetchPodcasts']),

        }
    }
</script>