import Admin from "../../components/admin/Admin";
import ApiConsumer from "../../components/admin/apiConsumer/ApiConsumer";
import AddApiConsumer from "../../components/admin/apiConsumer/AddApiConsumer";

import { pages } from "../pages";

export const adminRoutes = {
    path: '/admin',
    name: pages.Admin.Main,
    component: Admin,
    children: [
        {
            path: 'api-consumer',
            name: pages.Admin.ApiConsumerMain,
            component: ApiConsumer
        },
        {
            path: 'api-consumer/add',
            name: pages.Admin.ApiConsumerAdd,
            component: AddApiConsumer
        },
    ]
};
