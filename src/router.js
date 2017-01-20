import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from './Home.vue'
import Users from './Users.vue'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    { path: '/' , name: 'home', component: Home }
    ,{ path: '/users' , name: 'users', component: Users }
  ]
})

