import { ApiService } from "../apiService";
import {ApiConsumerModel} from "../../models/apiConsumer/apiConsumerModel";

export const apiConsumer = new ApiService(
    '/api/v1/admin/api-consumer',
    response => new ApiConsumerModel(response),
    request => request
);