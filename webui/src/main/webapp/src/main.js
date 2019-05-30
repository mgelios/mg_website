import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import store from './store'
import './filters/filters'
import VueRouter from 'vue-router'
import Dashboard from './components/dashboard/Dashboard'
import Profile from './components/profile/Profile'

Vue.config.productionTip = false;
Vue.use(VueRouter);

//const CryptoExample = CryptoCurrenciesTable;

const routes = [
    { path: '/dashboard', name: 'dashboard', component: Dashboard },
    { path: '/profile', name: 'profile', component: Profile }
];

const MyRouter = new VueRouter({
  routes
});

new Vue({
    store,
    router: MyRouter,
    render: h => h(App)
}).$mount('#app');
