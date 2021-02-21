<template>
    <div class="pa-4">
        <v-btn><v-icon left dark medium>post_add</v-icon> Add new api consumer</v-btn>
        <v-data-table
                v-if="apiConsumers"
                :headers="apiConsumersTableHeaders"
                :items="apiConsumers"
                :items-per-page="10"
        />
    </div>
</template>

<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'ApiConsumer',
        components: {},
        data: () => ({
            apiConsumersTableHeaders: [
                {
                    text: 'Name',
                    align: 'left',
                    sortable: true,
                    value: 'name'
                },
                {
                    text: 'Api key',
                    align: 'left',
                    sortable: true,
                    value: 'apiKey'
                },
                {
                    text: 'Token',
                    align: 'left',
                    sortable: true,
                    value: 'token'
                },
                {
                    text: 'Client ID',
                    align: 'left',
                    sortable: true,
                    value: 'clientId'
                },
                {
                    text: 'Client secret',
                    align: 'left',
                    sortable: true,
                    value: 'clientSecret'
                },
            ],
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