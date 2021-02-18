<template>
    <v-form>
        <div class="pa-4" v-if="apiConsumerToAdd">
            <v-text-field
                    label='Name'
                    v-model='apiConsumerToAdd.name'
                    outlined
                    dense
            ></v-text-field>
            <v-text-field
                    label='Api Key'
                    v-model='apiConsumerToAdd.apiKey'
                    outlined
                    dense
            ></v-text-field>
            <v-text-field
                    label='Token'
                    v-model='apiConsumerToAdd.token'
                    outlined
                    dense
            ></v-text-field>
            <v-text-field
                    label='Client ID'
                    v-model='apiConsumerToAdd.clientId'
                    outlined
                    dense
            ></v-text-field>
            <v-text-field
                    label='Client Secret'
                    v-model='apiConsumerToAdd.clientSecret'
                    outlined
                    dense
            ></v-text-field>
        </div>
        <v-btn
                elevation="2"
                @click="testButtonClick">
            Test
        </v-btn>
    </v-form>
</template>

<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'AddApiConsumer',
        components: {},
        data: () => ({

        }),
        computed: {
            ...mapState('apiConsumer', ['apiConsumerToAdd']),
        },
        mounted() {
            this.initApiConsumerToAdd();
        },
        methods: {
            ...mapActions('apiConsumer', ['initApiConsumerToAdd', 'saveApiConsumer']),
            testButtonClick: function() {
                console.log(this.apiConsumerToAdd);
                this.saveApiConsumer();
            }
        }
    }
</script>