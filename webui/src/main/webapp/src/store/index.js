import Vue from 'vue'
import Vuex from 'vuex'
import CryptoCurrency from './modules/CryptoCurrency'
import Weather from './modules/Weather'
import Currency from './modules/Currency'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        CryptoCurrency,
        Weather,
        Currency
    }
})