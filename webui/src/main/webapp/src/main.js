import Vue from 'vue'
import vuetify from './plugins/vuetify'
import App from './App.vue'
import store from './store'
import './filters/filters'
import VueRouter from 'vue-router'

import marked from 'marked'
import hljs from 'highlight.js';
import 'highlight.js/styles/tomorrow-night-eighties.css';

import { router } from './utils/router/router';

Vue.config.productionTip = false;
Vue.use(VueRouter);

const markedRenderer = new marked.Renderer();
markedRenderer.code = (code, language) => {
    const validLang = !!(language && hljs.getLanguage(language));
    const highlighted = validLang ? hljs.highlight(language, code).value : code;
    return `<pre><div class="hljs ${language}">${highlighted}</div></pre>`;
};

marked.setOptions({
    renderer: markedRenderer,
    sanitize: true
});

new Vue({
    store,
    router,
    vuetify,
    render: h => h(App)
}).$mount('#app');
