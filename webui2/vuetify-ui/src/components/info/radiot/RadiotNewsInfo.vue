<template>
    <div>
        {{articles}}
    </div>
</template>
<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'RadiotNewsInfo',
        components: {
        },
        data: function(){
            return {

            }
        },
        computed: {
            ...mapState('radio-t/news', ['articles']),
        },
        mounted() {
            this.fetchArticles();
        },
        methods: {
            ...mapActions('radio-t/news', ['fetchArticles']),

        }
    }
</script>