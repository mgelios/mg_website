<template>
    <v-content>
        <v-container>
            <Editor ref="editor" :outline="true" :preview="true" v-model="text" />
        </v-container>
    </v-content>
</template>

<script>
    import { Editor } from 'vuetify-markdown-editor';
    import 'emoji-mart-vue-fast/css/emoji-mart.css'
    export default {
        name: 'Test',
        components: {
            Editor
        },
        data() {
            return {
                text: ''
            };
        },
        mounted() {
            this.$refs.editor.focus();
            // Dark theme
            //this.$vuetify.theme.dark = true;
        }
    }
</script>

<style>

</style>
