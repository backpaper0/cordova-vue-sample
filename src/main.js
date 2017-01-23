import Vue from 'vue'

import router from './router'
import store from './store'

import 'bulma/css/bulma.css'
import 'font-awesome/css/font-awesome.css'
import 'animate.css/animate.css'

const f = mode => {
  store.dispatch('setMode', { mode })
}

const global = (new Function('return this'))()
if (global.cordova) {
  const onDeviceReady = () => {
    f('Cordova')
  }
  document.addEventListener('deviceready', onDeviceReady, false)
} else {
  f('Not Cordova')
}

new Vue({
  router,
  store
}).$mount('#app')

