import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import store from './store'
import './filters/filters'
import VueRouter from 'vue-router'
import ExampleChart from './components/example/ExampleChart'
import CryptoCurrenciesTable from './components/example/CryptoCurrenciesTable'

Vue.config.productionTip = false;
Vue.use(VueRouter);

const Example = ExampleChart;
const CryptoExample = CryptoCurrenciesTable;

const routes = [
    { path: '/example', component: Example },
    { path: '/home', component: Example },
    { path: '/crypto', component: CryptoExample }
];

const router = new VueRouter({
  routes
});

new Vue({
    store,
    router,
    render: h => h(App)
}).$mount('#app')
