export const getters = Object.freeze({
    viewPageInputsConfig,
});

function viewPageInputsConfig(state) {
    if (state.activeProfile) {
        return {
            inputs: [
                {
                    label: 'UUID',
                    model: state.activeProfile.uuid,
                    readOnly: true,
                    type: 'TEXT',
                },
                {
                    label: 'Username',
                    model: state.activeProfile.username,
                    readOnly: true,
                    type: 'TEXT',
                },
                {
                    label: 'Email',
                    model: state.activeProfile.email,
                    readOnly: true,
                    type: 'TEXT',
                },
                {
                    label: 'Role',
                    model: state.activeProfile.role,
                    readOnly: true,
                    type: 'TEXT',
                },
                {
                    label: 'First name',
                    model: state.activeProfile.firstName,
                    readOnly: true,
                    type: 'TEXT',
                },
                {
                    label: 'Last name',
                    model: state.activeProfile.lastName,
                    readOnly: true,
                    type: 'TEXT',
                },
            ],
        }
    }
    return null;
}