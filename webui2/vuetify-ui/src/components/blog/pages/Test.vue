<template>
    <v-content>
        <v-container fluid grid-list-md>
            <v-layout row wrap fill-height>
                <v-flex xs12 lg6>
                    <v-textarea
                            v-model="text"
                            v-on:input="updateText"
                            :auto-grow="true"
                            background-color="green lighten-5"
                            :solo="true">
                    </v-textarea>
                </v-flex>
                <v-flex xs12 lg6>
                    <v-container v-html="compiledText"></v-container>
                </v-flex>
            </v-layout>
        </v-container>
    </v-content>
</template>

<script>
    import { marked } from 'marked'

    export default {
        name: 'Test',
        components: {
        },
        data() {
            return {
                text: '## paste your text here',
                compiledText: ''
            };
        },
        methods: {
            updateText: function() {
                this.compiledText = marked(this.text);
            }
        },
        mounted() {
            this.updateText();
        }
    }
</script>

<style>

</style>
