import Axios from 'axios';

Axios.defaults.headers.common.Accept = 'application/json';

export const axios = Axios;