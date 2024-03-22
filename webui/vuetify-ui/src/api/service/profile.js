import { ApiService } from "../apiService";
import { ProfileModel } from "../../models/profile/profileModel";

export const login = new ApiService(
    '/api/v1/token/login',
    response => response,
    request => request
);

export const profile = new ApiService(
    '/api/v1/authorized/profile',
    response => new ProfileModel(response),
    request => request
);




