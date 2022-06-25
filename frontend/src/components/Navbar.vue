<template>
  <div class="center">
    <vs-navbar
      color="primary"
      text-white
      center-collapsed
      v-model="active"
      fixed
      class="navigationBar"
    >
      <template #left>
        <span class="elementsInline"
          ><img src="../assets/logo.png" alt="" width="30" />
          <p>MyAnimeList</p></span
        >
      </template>
      <vs-navbar-item :active="active == 'home'" id="home">
        Home
      </vs-navbar-item>
      <vs-navbar-item :active="active == 'popular'" id="popular">
        Popular 🔥
      </vs-navbar-item>
      <vs-navbar-item :active="active == 'recommended'" id="recommended">
        Recommended ⭐️
      </vs-navbar-item>
      <vs-navbar-item :active="active == 'genre'" id="genre">
        Genre 🎭
      </vs-navbar-item>
      <template #right>
        <vs-button animation-type="rotate">
          <i class="bx bx-user"></i>
          <template #animate> Login </template>
        </vs-button>
      </template>
    </vs-navbar>
  </div>
</template>

<script>
export default {
  name: "NavigationTop",
  data: () => ({
    active: "home",
  })
};
</script>

<style lang="css">
.elementsInline p {
  font-size: 20px;
  display: inline-block;
  vertical-align: middle;
}

.elementsInline img {
  vertical-align: middle;
  margin-right: 10px;
}
</style>
