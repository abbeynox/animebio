<template>
  <div id="app">
    <navigationTop/>
    <router-view />
  </div>
</template>

<script>
import NavigationTop from './components/Navbar.vue';

export default {
  name: 'App',
  components: {
    NavigationTop
}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
