<template>
    <div class="pa-4">
        <v-btn><v-icon left dark medium>post_add</v-icon> Add new api consumer</v-btn>
        <v-btn @click="dialogActive = !dialogActive">Open dialog</v-btn>
        <v-data-table
                v-if="apiConsumers"
                :headers="apiConsumersTableHeaders"
                :items="apiConsumers"
                :items-per-page="10"
        >
            <template v-slot:item.actions>
                <v-btn icon>
                    <v-icon>edit</v-icon>
                </v-btn>
                <v-btn icon>
                    <v-icon>delete</v-icon>
                </v-btn>
            </template>
        </v-data-table>
        <v-dialog v-model="dialogActive" max-width="500">
            Some text
        </v-dialog>
    </div>
</template>

<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'ApiConsumer',
        components: {},
        data: () => ({
            dialogActive: false,
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
                {
                    text: 'Actions',
                    align: 'right',
                    sortable: true,
                    value: 'actions'
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