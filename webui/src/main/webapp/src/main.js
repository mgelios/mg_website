import Vue from 'vue'
import vuetify from './plugins/vuetify'
import App from './App.vue'
import store from './store'
import './filters/filters'
import VueRouter from 'vue-router'
import Dashboard from './components/dashboard/Dashboard'
import WeatherDashboardPage from './components/dashboard/pages/Weather'
import FinanceDashboardPage from './components/dashboard/pages/Finance'
import MainDashboardPage from './components/dashboard/pages/Main'
import CryptoMarketDashboardPage from './components/dashboard/pages/CryptoMarket'
import Profile from './components/profile/Profile'
import Test from './components/blog/pages/Test'
import Blog from './components/blog/Blog'

Vue.config.productionTip = false;
Vue.use(VueRouter);

//const CryptoExample = CryptoCurrenciesTable;

const routes = [
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
            }
        ]
    },
    {
        path: '/profile',
        name: 'profile',
        component: Profile
    }
];

const MyRouter = new VueRouter({
  routes
});

new Vue({
    store,
    router: MyRouter,
    vuetify,
    render: h => h(App)
}).$mount('#app');
