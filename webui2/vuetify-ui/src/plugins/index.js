import {loadFonts} from './webfontloader'
import vuetify from './vuetify'
import router from '@/router'
import marked from './marked'

export function registerPlugins(app) {
    loadFonts()
    app
        .use(vuetify)
        .use(router)
        .use(marked)
}
