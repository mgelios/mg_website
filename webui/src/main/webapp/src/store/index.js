import Vue from 'vue'
import Vuex from 'vuex'
import CryptoCurrency from './modules/CryptoCurrency'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        CryptoCurrency
    }
})