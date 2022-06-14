import 'vuesax/dist/vuesax.css'

import App from './App.vue'
import Vue from 'vue'
import Vuesax from 'vuesax'

Vue.use(Vuesax)

Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')
