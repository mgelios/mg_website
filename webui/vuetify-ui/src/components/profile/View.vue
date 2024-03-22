<template>
    <v-form>
        <InputsContainer v-if="viewPageInputsConfig" v-bind:configuration="viewPageInputsConfig" />
    </v-form>
</template>

<script>
    import { mapState, mapActions, mapGetters } from 'vuex';

    import InputsContainer from "../common/inputs/InputsContainer";

    export default {
        name: 'ProfileView',
        components: {
            InputsContainer,
        },
        data: () => ({
        }),
        computed: {
            ...mapState('profile', ['activeProfile']),
            ...mapGetters('profile', ['viewPageInputsConfig']),
        },
        mounted() {
            this.fetchProfile('');
        },
        methods: {
            ...mapActions('profile', ['fetchProfile']),
        }
    }
</script>