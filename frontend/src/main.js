import 'vuesax/dist/vuesax.css'

import App from './App.vue'
import Vue from 'vue'
import Vuesax from 'vuesax'

Vue.use(Vuesax, {
  colors: { // TODO: Search for color guidelines -> Jade
    primary:'#BC73FF', // YWK Purple
    success:'#15b75b', // Green
    danger:'#ff3300', // Red
    warning:'#ff8200', // Orange
    dark:'#242145',
  }
})

Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')
