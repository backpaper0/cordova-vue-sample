<template>
  <div>
    <nav class="nav">
      <div class="nav-left">
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
    <div class="modal" :class="{ 'is-active': shownAboutThisApp }">
      <div class="modal-background" @click="hideAboutThisApp"></div>
      <div class="modal-content">
        <div class="box">
          <article class="media">
            <div class="media-left">
              <figure class="image is-64x64">
                <img src="https://www.gravatar.com/avatar/e107c65b007e7abb6b2e53054428fb5a">
              </figure>
            </div>
            <div class="media-content">
              <div class="content">
                <p>
                  <a href="https://github.com/backpaper0/cordova-vue-sample">
                    backpaper0/cordova-vue-sample
                  </a>
                </p>
                <hr>
                <p>Use following:</p>
                <ul>
                  <li><a href="https://cordova.apache.org/">Cordova</a></li>
                  <li><a href="https://jp.vuejs.org/">Vue.js</a></li>
                  <li><a href="https://vuex.vuejs.org/ja/">Vuex</a></li>
                  <li><a href="https://router.vuejs.org/ja/">vue-router 2</a></li>
                  <li><a href="https://github.com/mzabriskie/axios">axios</a></li>
                  <li><a href="http://bulma.io/">Bulma</a></li>
                  <li><a href="http://fontawesome.io/icons/">Font Awesome icons</a></li>
                  <li><a href="https://webpack.js.org/">webpack</a></li>
                  <li><a href="https://www.npmjs.com/">npm</a></li>
                  <li><a href="https://babeljs.io/learn-es2015/">Babel and ES2015</a></li>
                </ul>
              </div>
            </div>
          </article>
        </div>
      </div>
      <button class="modal-close" @click="hideAboutThisApp"></button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'header',
  data () {
    return {
      menuOpened: false,
      shownAboutThisApp: false
    }
  },
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
