import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import store from './store'
import './filters/filters'
import VueRouter from 'vue-router'
import Dashboard from './components/dashboard/Dashboard'
import Login from './components/profile/Login'

Vue.config.productionTip = false;
Vue.use(VueRouter);

//const CryptoExample = CryptoCurrenciesTable;

const routes = [
    { path: '/dashboard', component: Dashboard },
    { path: '/login', component: Login}
];

const router = new VueRouter({
  routes
});

new Vue({
    store,
    router,
    render: h => h(App)
}).$mount('#app');
