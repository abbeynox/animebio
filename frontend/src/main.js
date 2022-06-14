import 'vuesax/dist/vuesax.css'

import App from './App.vue'
import Vue from 'vue'
import Vuesax from 'vuesax'

Vue.use(Vuesax, {
  colors: { // TODO: Search for color guidelines -> Jade
    primary:'#5b3cc4',
    success:'rgb(23, 201, 100)',
    danger:'rgb(242, 19, 93)',
    warning:'rgb(255, 130, 0)',
    dark:'rgb(36, 33, 69)',
    light:'rgb(255,255,255)'
  }
})

Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')
