export async function requestExceptionWrapper(request, dataMapper) {
    try {
        const data = await request();
        console.log(data, dataMapper);
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