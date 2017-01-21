<template>
  <div class="box">
    <article class="media">
      <div class="media-left">
        <figure class="image is-64x64">
          <img :src="user.avatar_url" alt="Image">
        </figure>
      </div>
      <div class="media-content">
        <div class="content">
          <p>
            <a :href="user.html_url">
              <strong>{{ user.login }}</strong>
            </a>
          </p>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
export default {
  name: 'user',
  props: ['user'],
  data () {
    return {
    }
  }
}
</script>

<style>
</style>
