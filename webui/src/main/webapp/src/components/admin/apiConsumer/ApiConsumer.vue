<template>
    <div>{{apiConsumers}}</div>
</template>

<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'ApiConsumer',
        components: {},
        data: () => ({

        }),
        computed: {
            ...mapState('apiConsumer', ['apiConsumers']),
        },
        mounted() {
            this.fetchApiConsumers();
        },
        methods: {
            ...mapActions('apiConsumer', ['fetchApiConsumers']),
        }
    }
</script>