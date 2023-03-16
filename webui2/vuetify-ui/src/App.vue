<template>
    <router-view/>
</template>

<script>

import {mapActions, mapState} from 'vuex';

export default {
    name: 'App',
    components: {},
    data() {
        return {}
    },
    computed: {
        //...mapState('app', ['appData']),
        ...mapState({appData: state => state})
    },
    created() {
        console.log(this.appData)
        if (localStorage.getItem('appData') && !this.appData) {
            this.restoreDataFromLocalStorage(JSON.parse(localStorage.getItem('appData')));
        } else if (!localStorage.getItem('appData') && this.appData) {
            localStorage.setItem(JSON.stringify(this.appData));
        }
    },
    methods: {
        ...mapActions('app', ['restoreDataFromLocalStorage']),
    }
}
</script>
