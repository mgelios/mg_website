<template>
    <v-form>
        <div class="pa-4" v-if="activeProfile">
            <v-text-field
                    label='UUID'
                    v-model='activeProfile.uuid'
                    outlined
                    dense
                    readonly
            ></v-text-field>
            <v-text-field
                    label='Username'
                    v-model='activeProfile.username'
                    outlined
                    dense
                    readonly
            ></v-text-field>
            <v-text-field
                    label='email'
                    v-model='activeProfile.email'
                    outlined
                    dense
                    readonly
            ></v-text-field>
            <v-text-field
                    label='Role'
                    v-model='activeProfile.role'
                    outlined
                    dense
                    readonly
            ></v-text-field>
            <v-text-field
                    label='First name'
                    v-model='activeProfile.firstName'
                    outlined
                    dense
            ></v-text-field>
            <v-text-field
                    label='Last name'
                    v-model='activeProfile.lastName'
                    outlined
                    dense
            ></v-text-field>
        </div>
    </v-form>
</template>

<script>
    import { mapState, mapActions } from 'vuex';

    export default {
        name: 'ProfileView',
        components: {},
        data: () => ({

        }),
        computed: {
            ...mapState('profile', ['activeProfile']),
        },
        mounted() {
            this.fetchProfile('');
        },
        methods: {
            ...mapActions('profile', ['fetchProfile']),
        }
    }
</script>