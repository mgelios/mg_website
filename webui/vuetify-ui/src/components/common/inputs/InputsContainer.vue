<template>
    <div class="pa-4" v-if="configuration.inputs">
        <template v-for="input in configuration.inputs">
            <v-text-field
                    v-bind:key="input.label"
                    v-if="input.type === 'TEXT'"
                    v-model="input.model"
                    :label="input.label"
                    :readonly="input.readOnly"
                    dense
                    outlined
            />
        </template>
    </div>
</template>
<script>
    export default {
        name: 'InputsContainer',
        components: {},
        props: {
            configuration: {
                default: null,
            }
        },
        data: () => ({}),
    }
</script>