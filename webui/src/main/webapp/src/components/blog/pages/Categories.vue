<template>
    <v-content>
        <v-text-field v-model="categoryName"></v-text-field>
        <v-btn v-on:click="sendCategory">Press me</v-btn>
    </v-content>
</template>

<script>
    export default {
        name: 'Categories',
        components: {
        },
        data() {
            return {
                categoryName: ''
            };
        },
        methods: {
            sendCategory: function() {
                this.$store.dispatch('Blog/triggerCategoryCreation',
                    {
                        name: this.categoryName
                    }
                );
            }
        }
    }
</script>

<style>

</style>