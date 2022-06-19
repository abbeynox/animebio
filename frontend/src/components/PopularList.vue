<template>
  <section-container sectionTitle="Popular" sectionIcon="bx bxs-hot">
    <vs-card-group>
      <vs-card v-for="anime in animes" :key="anime.id">
        <template #title>
          <h3>{{ anime.animeTitle }}</h3>
        </template>
        <template #img>
          <img :src="anime.animeImg" alt="anime img" />
        </template>
        <template #text>
          <p>{{ anime.animeDescription }}</p>
        </template>
        <template #interactions>
          <vs-button danger icon>
            <i class="bx bx-heart"></i>
          </vs-button>
        </template>
      </vs-card>
    </vs-card-group>
  </section-container>
</template>

<script>
import SectionContainer from "../containers/SectionContainer.vue";
import animes from "../mock-data/animes.js";

export default {
  name: "PopularList",
  components: {
    SectionContainer,
  },
  props: {
    animeTitle: {
      type: String,
      required: true,
      default: "Title",
    },
    animeDescription: {
      type: String,
      required: true,
      default: "Description",
    },
    animeImg: {
      type: String,
      required: true,
      default: "http://localhost:8080/img/touka2.1221dd00.png",
    },
    animeScore: {
      type: Number,
      required: true,
      default: 0,
    },
    animeScoreRank: {
      type: Number,
      required: true,
      default: 0,
    },
    animePopularityRank: {
      type: Number,
      required: true,
      default: 0,
    },
  },
  data: function () {
    return {
      animes: animes
    };
  },
};
</script>

<style lang="scss" scoped></style>
