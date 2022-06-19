<template>
  <div>
    <WelcomeHero />
    <PopularList />
  </div>
</template>

<script>
import WelcomeHero from '../components/WelcomeHero.vue';
import PopularList from '@/components/PopularList.vue';
export default {
  name: "HomeView",
  title: "Home",
  components: {
    WelcomeHero,
    PopularList
},
};
</script>

<style lang="scss" scoped></style>
