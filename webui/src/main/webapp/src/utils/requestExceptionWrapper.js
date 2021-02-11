export async function requestExceptionWrapper(response) {
    try {
        const data = response.data;

        return {
            success: true,
            data
        }
    } catch (error) {
        console.error('Request error: ', error);

        return {
            success: false,
            error
        }
    }
}