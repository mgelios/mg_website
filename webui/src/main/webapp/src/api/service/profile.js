import { ApiService } from "../apiService";

export const login = new ApiService(
    '/api/v1/token/login',
    response => response,
    request => request
);

export const profile = new ApiService(
    '/api/v1/authorized/profile',
    response => response,
    request => request
);




