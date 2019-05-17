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
    { path: '/dashboard', component: Dashboard },
    { path: '/profile', component: Profile}
];

const router = new VueRouter({
  routes
});

new Vue({
    store,
    router,
    render: h => h(App)
}).$mount('#app');
