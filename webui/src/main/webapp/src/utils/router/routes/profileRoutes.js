import Profile from "../../../components/profile/Profile";
import View from "../../../components/profile/View";
import Login from "../../../components/profile/Login";

import { pages } from "../pages";

export const profileRoutes = {
    path: '/profile',
    name: pages.Profile.Main,
    component: Profile,
    children: [
        {
            path: 'view',
            name: pages.Profile.View,
            component: View
        },
    ]
};

export const loginRoute = {
    path: '/login',
    name: pages.Profile.Login,
    component: Login
}