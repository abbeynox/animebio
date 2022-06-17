<template>
  <div class="hero">
    <h1 class="hero-header">Willkommen bei MyAnimeList</h1>
    <div class="hero-image">
      <img src="../../public/platzhalter-image-1.svg" alt="platzhalter">
    </div>

  </div>
</template>

<script>

export default {
    name: 'WelcomeHero'
};
</script>

<style>
.hero-header {
  font-size: 100px;
  float: left;
  width: 50%;
}
.hero-image {
  float: right;
  width: 50%;
}
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>