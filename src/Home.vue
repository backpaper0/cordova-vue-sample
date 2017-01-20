<template>
  <section class="section">
    <h1 class="title">Cordova Vue Sample</h1>
    <p class="control has-addons">
      <input type="text" class="input is-expanded" placeholder="Search users" v-model="q">
      <button class="button is-primary" :class="{ 'is-loading': loading, disabled: ! q }" @click="searchUsers" :disabled="! q">
        <span class="icon">
          <i class="fa fa-search"></i>
        </span>
        <span>Search</span>
      </button>
    </p>
  </section>
</template>

<script>
export default {
  name: 'home',
  data () {
    return {
      q: '',
      loading: false
    }
  },
  methods: {
    searchUsers () {
      this.loading = true
      this.$store
        .dispatch('searchUsers', this.q)
        .then(() => {
          this.loading = false
          this.$router.push('/users')
        })
    }
  }
}
</script>

<style>
</style>
