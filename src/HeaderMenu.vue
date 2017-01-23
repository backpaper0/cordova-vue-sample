<template>
  <div>
    <nav class="nav">
      <div class="nav-left">
        <a class="nav-item">
          {{ mode }}
        </a>
      </div>

      <span class="nav-toggle" :class="{ 'is-active': menuOpened }" @click="toggleMenu">
        <span></span>
        <span></span>
        <span></span>
      </span>

      <div class="nav-right nav-menu" :class="{ 'is-active': menuOpened }">
        <a class="nav-item" @click="showAboutThisApp">
          About this app
        </a>
      </div>
    </nav>
    <div class="modal" :class="{ 'is-active': shownAboutThisApp, 'animated': shownAboutThisApp, 'fadeIn': shownAboutThisApp }">
      <div class="modal-background" @click="hideAboutThisApp"></div>
      <div class="modal-content">
        <About></About>
      </div>
      <button class="modal-close" @click="hideAboutThisApp"></button>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import About from './About.vue'

export default {
  name: 'header',
  components: { About },
  data () {
    return {
      menuOpened: false,
      shownAboutThisApp: false
    }
  },
  computed: mapState(['mode']),
  methods: {
    toggleMenu () {
      this.menuOpened = (! this.menuOpened)
    },
    showAboutThisApp () {
      this.menuOpened = false
      this.shownAboutThisApp = true
    },
    hideAboutThisApp () {
      this.shownAboutThisApp = false
    }
  }
}
</script>

<style>
</style>
