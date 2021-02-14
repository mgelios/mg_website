export async function requestExceptionWrapper(request, dataMapper = data => data) {
    try {
        const response = await request();
        const data = dataMapper(response.data);
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