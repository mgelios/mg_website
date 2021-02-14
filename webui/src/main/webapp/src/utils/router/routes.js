import Dashboard from "../../components/dashboard/Dashboard";
import MainDashboardPage from "../../components/dashboard/pages/Main";
import WeatherDashboardPage from "../../components/dashboard/pages/Weather";
import FinanceDashboardPage from "../../components/dashboard/pages/Finance";
import CryptoMarketDashboardPage from "../../components/dashboard/pages/CryptoMarket";
import Blog from "../../components/blog/Blog";
import Test from "../../components/blog/pages/Test";
import BlogCategories from "../../components/blog/pages/Categories";
import Profile from "../../components/profile/Profile";
import Login from "../../components/profile/Login";

export const routes = [
    {
        path: '/dashboard',
        name: 'dashboard',
        component: Dashboard,
        children: [
            {
                path: 'main',
                name: 'dashboardMainPage',
                component: MainDashboardPage
            },
            {
                path: 'weather',
                name: 'dashboardWeatherPage',
                component: WeatherDashboardPage
            },
            {
                path: 'finance',
                name: 'dashboardFinancePage',
                component: FinanceDashboardPage
            },
            {
                path: 'crypto',
                name: 'dashboardCryptoMarketPage',
                component: CryptoMarketDashboardPage
            },
        ]
    },
    {
        path: '/blog',
        name: 'blog',
        component: Blog,
        children: [
            {
                path: 'test',
                name: 'testPage',
                component: Test
            },
            {
                path: 'categories',
                name: 'categoriesPage',
                component: BlogCategories
            }
        ]
    },
    {
        path: '/profile',
        name: 'profile',
        component: Profile
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    }
];