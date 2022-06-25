<template>
  <div id="app">
    <navigationTop />
    <MainContainer>
      <router-view />
    </MainContainer>
  </div>
</template>

<script>
import NavigationTop from "./components/Navbar.vue";
import MainContainer from "./containers/MainContainer.vue";

export default {
  name: "App",
  components: {
    NavigationTop,
    MainContainer,
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Montserrat:300,400,700,800");
#app {
  font-family: "Montserrat", helvetica, arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
