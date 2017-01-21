<template>
  <div>
    <Header></Header>
    <section class="section">
      <h1 class="title">Cordova Vue Sample</h1>
      <p class="control">
        <input type="text" class="input is-expanded" :class="{ 'is-danger': invalidQ }" placeholder="Search GitHub users" v-model="q">
        <span class="help is-danger" v-if="invalidQ">
          Query is required
        </span>
      </p>
      <label class="label">Sort</label>
      <p class="control">
        <span class="select">
          <select v-model="sort">
            <option></option>
            <option value="followers">Sort by followers</option>
            <option value="repositories">Sort by repositories</option>
            <option value="joined">Sort by joined</option>
          </select>
        </span>
      </p>
      <hr>
      <p class="control">
        <button class="button is-primary" :class="{ 'is-loading': loading }" @click="searchUsers">
          <span class="icon">
            <i class="fa fa-search"></i>
          </span>
          <span>Search</span>
        </button>
      </p>
    </section>
  </div>
</template>

<script>
import Header from './Header.vue'

export default {
  name: 'home',
  components: { Header },
  data () {
    return {
      q: '',
      sort: '',
      loading: false,
      invalidQ: false
    }
  },
  watch: {
    q (val, oldVal) {
      if (val) {
        this.invalidQ = false
      }
    }
  },
  methods: {
    searchUsers () {
      if (! this.q) {
        this.invalidQ = true
        return
      }
      this.loading = true
      this.$store
      .dispatch('searchUsers', { q: this.q, sort: this.sort })
        .then(() => {
          this.loading = false
          this.$router.push('/users')
        })
    }
  },
  created () {
    this.q = this.$store.state.q
    this.sort = this.$store.state.sort
  },
  beforeDestroy () {
    this.$store.dispatch('save', { q: this.q, sort: this.sort })
  }
}
</script>

<style>
</style>
