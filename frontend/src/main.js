import 'vuesax/dist/vuesax.css'

import App from './App.vue'
import Vue from 'vue'
import VueRouter from 'vue-router';
import Vuesax from 'vuesax';
import router from './routes/';
import VueAxios from 'vue-axios';

Vue.use(VueRouter);
Vue.use (VueAxios);

Vue.use(Vuesax, {
  colors: { // TODO: Search for color guidelines -> Jade
    primary:'#420080', // YWK Purple
    success:'#15b75b', // Green
    danger:'#ff3300', // Red
    warning:'#ff8200', // Orange
    dark:'#242145',
  }
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
