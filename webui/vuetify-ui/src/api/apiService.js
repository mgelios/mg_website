import { axios } from '../utils/axios';
import { requestExceptionWrapper } from "../utils/requestExceptionWrapper";

export class ApiService {

    /**
     * @param {String} endpointBasePath
     * @param {Function} [responseMapper] - map response data from api
     * @param {Function} [requestMapper] - map request data to api
     */
    constructor(endpointBasePath, responseMapper, requestMapper) {
        this.basePath = endpointBasePath;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }

    transformConfig(config = null) {
        return {
            baseURL: this.baseUrl,
            ...(config || {})
        };
    }

    async get(id, axiosConfig) {
        return requestExceptionWrapper(
            () => axios.get(this.basePath + id, this.transformConfig(axiosConfig)),
            this.responseMapper
        );
    }

    async getList(axiosConfig) {
        return requestExceptionWrapper(
            () => axios.get(this.basePath + '/list', this.transformConfig(axiosConfig)),
            response => response.map(this.responseMapper)
        );
    }

    async getMap(axiosConfig) {
        return requestExceptionWrapper(
            () => axios.get(this.basePath + '/map', this.transformConfig(axiosConfig)),
            response => {
                let result = new Map();
                Object.keys(response).forEach((key) => {
                    result.set(key, response[key].map(this.responseMapper));
                });
                return result;
            }
        );
    }

    async post(requestBody, axiosConfig) {
        return requestExceptionWrapper(
            () => axios.post(this.basePath, this.requestMapper(requestBody), this.transformConfig(axiosConfig)),
            this.responseMapper
        );
    }

    async put(requestBody, axiosConfig) {
        return requestExceptionWrapper(
            () => axios.put(this.basePath, this.requestMapper(requestBody), this.transformConfig(axiosConfig)),
            this.responseMapper
        );
    }

    async patch(requestBody, axiosConfig) {
        return requestExceptionWrapper(
            () => axios.patch(this.basePath, this.requestMapper(requestBody), this.transformConfig(axiosConfig)),
            this.responseMapper
        );
    }

    async delete(id, axiosConfig) {
        return requestExceptionWrapper(
            () => axios.delete(this.basePath + id, this.transformConfig(axiosConfig))
        );
    }
}