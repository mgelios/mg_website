import Dashboard from "../../components/dashboard/Dashboard";
import MainDashboardPage from "../../components/dashboard/pages/Main";
import WeatherDashboardPage from "../../components/dashboard/pages/Weather";
import FinanceDashboardPage from "../../components/dashboard/pages/Finance";
import CryptoMarketDashboardPage from "../../components/dashboard/pages/CryptoMarket";

import { pages } from "../pages";

export const dashboardRoutes = {
    path: '/dashboard',
    name: pages.Dashboard.Root,
    component: Dashboard,
    children: [
        {
            path: 'main',
            name: pages.Dashboard.Main,
            component: MainDashboardPage
        },
        {
            path: 'weather',
            name: pages.Dashboard.Weather,
            component: WeatherDashboardPage
        },
        {
            path: 'finance',
            name: pages.Dashboard.Finance,
            component: FinanceDashboardPage
        },
        {
            path: 'crypto',
            name: pages.Dashboard.Crypto,
            component: CryptoMarketDashboardPage
        },
    ]
};
