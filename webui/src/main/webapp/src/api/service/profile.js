import { ApiService } from "../apiService";

export const login = new ApiService(
    '/api/v1/token/login',
    response => response,
    request => request
);


