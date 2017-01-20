<template>
  <transition name="slide">
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
      <div class="box" v-for="user in users">
        <article class="media">
          <div class="media-left">
            <figure class="image is-64x64">
              <img :src="user.avatar_url" alt="Image">
            </figure>
          </div>
          <div class="media-content">
            <div class="content">
              <p>
                <strong>{{ user.login }}</strong>
              </p>
            </div>
          </div>
        </article>
      </div>
    </section>
  </transition>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'users',
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
