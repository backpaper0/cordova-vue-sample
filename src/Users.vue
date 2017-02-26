<template>
  <transition name="slide">
    <div id="users-page">
      <HeaderMenu></HeaderMenu>
      <section class="section">
        <h1 class="title">Cordova Vue Sample</h1>
        <p class="control">
          <router-link to="/" class="button is-link">
            <span class="icon">
              <i class="fa fa-angle-double-left"></i>
            </span>
            <span>Return</span>
          </router-link>
        </p>
        <User v-for="user in users" :user="user"></User>
        <article class="message is-warning" v-if="users.length == 0">
          <div class="message-body">
            No users
          </div>
        </article>
      </section>
    </div>
  </transition>
</template>

<script>
import { mapState } from 'vuex'
import HeaderMenu from './HeaderMenu.vue'
import User from './User.vue'

export default {
  name: 'users',
  components: { HeaderMenu, User },
  data () {
    return {
    }
  },
  computed: mapState(['users'])
}
</script>

<style>
.slide-enter-active, .slide-leave-active {
  transition: all .3s 0s ease;
}
.slide-enter, .slide-leave-to {
  transform: translateY(100%);
}
</style>
