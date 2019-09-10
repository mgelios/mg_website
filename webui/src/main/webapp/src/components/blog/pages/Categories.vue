<template>
    <v-content>
        <v-text-field v-model="categoryName"></v-text-field>
        <v-btn v-on:click="sendCategory">Press me</v-btn>
        <v-list-group
                no-action
                value="true"
                v-for="(item, i) in testCategories"
                :key="i"
                :prepend-icon="item.icon">

            <template v-slot:activator>
                <v-list-item-title>{{item.name}}</v-list-item-title>
                <v-list-item-action><v-btn><v-icon>add</v-icon></v-btn></v-list-item-action>
                <v-list-item-action><v-btn><v-icon>edit</v-icon></v-btn></v-list-item-action>
                <v-list-item-action><v-btn><v-icon>delete_forever</v-icon></v-btn></v-list-item-action>
            </template>
            <v-list-item
                    no-action
                    sub-group
                    value="true"
                    v-for="(subitem, j) in item.subcategories"
                    :key="j"
                    link>
                <v-list-item-avatar><v-icon>{{subitem.icon}}</v-icon></v-list-item-avatar>
                <v-list-item-title>{{subitem.name}}</v-list-item-title>
                <v-list-item-action><v-icon>delete_forever</v-icon></v-list-item-action>
                <v-list-item-action><v-icon>edit</v-icon></v-list-item-action>
            </v-list-item>
        </v-list-group>
    </v-content>
</template>

<script>
    export default {
        name: 'Categories',
        components: {
        },
        data() {
            return {
                categoryName: '',
                testCategories: [
                    {
                        name: 'first category',
                        description: 'some desc',
                        icon: 'account_circle',
                        subcategories: [
                            {
                                name: 'first category first subcategory',
                                description: 'some desc',
                                icon: 'all_inbox'
                            },
                            {
                                name: 'first category second subcategory',
                                description: 'some desc',
                                icon: 'exit_to_app'
                            }
                        ]
                    },
                    {
                        name: 'second category',
                        description: 'some desc',
                        icon: 'alarm',
                        subcategories: [
                            {
                                name: 'second category first subcategory',
                                description: 'some desc',
                                icon: 'motorcycle'
                            },
                            {
                                name: 'second category second subcategory',
                                description: 'some desc',
                                icon: 'label'
                            }
                        ]
                    }
                ]
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