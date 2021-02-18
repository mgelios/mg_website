<template>
    <v-list dense>
        <div>{{apiConsumers}}</div>
        <v-list-item-group>
            <v-list-item v-for="apiConsumer in apiConsumers" :key="apiConsumer">
                <v-list-item-content>{{apiConsumer.uuid}}  {{apiConsumer.name}}</v-list-item-content>
            </v-list-item>
        </v-list-item-group>
    </v-list>
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