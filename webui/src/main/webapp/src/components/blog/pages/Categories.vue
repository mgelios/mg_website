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
            </template>
            <v-btn fab small text v-on:click="testAction">
                <v-icon>add</v-icon>
            </v-btn>
            <v-btn fab small text v-on:click="testAction">
                <v-icon>edit</v-icon>
            </v-btn>
            <v-btn fab small text v-on:click="testAction">
                <v-icon>delete_forever</v-icon>
            </v-btn>
            <v-list-item
                    no-action
                    sub-group
                    value="true"
                    v-for="(subitem, j) in item.subcategories"
                    :key="j"
                    link>
                <v-list-item-avatar><v-icon>{{subitem.icon}}</v-icon></v-list-item-avatar>
                <v-list-item-title>{{subitem.name}}</v-list-item-title>
                <v-list-item-action>
                    <v-btn fab small text v-on:click="secondTestAction">
                        <v-icon>delete_forever</v-icon>
                    </v-btn>
                </v-list-item-action>
                <v-list-item-action>
                    <v-btn fab small text v-on:click="secondTestAction">
                        <v-icon>edit</v-icon>
                    </v-btn>
                </v-list-item-action>
            </v-list-item>
        </v-list-group>
        <v-dialog v-model="dialogOpened">
            <v-card>
                <v-card-title>
                    <span class="headline">Add subcategory</span>
                    <span class="headline">Parent category: category</span>
                </v-card-title>
                <v-card-text>
                    <v-text-field outlined label="icon"></v-text-field>
                    <v-text-field outlined label="name"></v-text-field>
                    <v-text-field outlined label="description"></v-text-field>
                </v-card-text>
                <v-card-actions>
                    <v-btn color="blue darken-1" text @click="dialogOpened = false">Cancel</v-btn>
                    <div class="flex-grow-1"></div>
                    <v-btn color="blue darken-1" text>Create subcategory</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-content>
</template>

<script>
    //import { mapState } from 'vuex';

    export default {
        name: 'Categories',
        components: {
        },
        data() {
            return {
                categoryName: '',
                dialogOpened: false,
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
            },
            testAction: function() {
                this.categoryName = "alala";
                this.dialogOpened = true;
            },
            secondTestAction: function() {
                this.categoryName = "lalala";
            },
            createSubcategory: function() {

            }
        },
        mounted: function() {
            this.$store.dispatch('Currency/getCurrencyConversions');
        }
    }
</script>

<style>

</style>