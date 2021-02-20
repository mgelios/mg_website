import { dashboardRoutes } from "./dashboardRoutes";
import { blogRoutes } from "./blogRoutes";
import { profileRoutes, loginRoute } from "./profileRoutes";
import { adminRoutes } from "./adminRoutes";

export const routes = [
    dashboardRoutes ,
    blogRoutes,
    profileRoutes,
    adminRoutes,
    loginRoute,
];