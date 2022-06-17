<template>
  <section-container>
    <vs-card-group>
      <vs-card>
        <template #title>
          <h3>{{ animeTitle }}</h3>
        </template>
        <template #img>
          <img :src="`/foto${card}.png`" alt="" />
        </template>
        <template #text>
          <p>{{ animeDescription }}</p>
        </template>
        <template #interactions>
          <vs-button danger icon>
            <i class="bx bx-heart"></i>
          </vs-button>
          <vs-button class="btn-chat" shadow primary>
            <i class="bx bx-chat"></i>
            <span class="span"> {{ animeScore }} </span>
          </vs-button>
        </template>
      </vs-card>
    </vs-card-group>
  </section-container>
</template>

<script>
import SectionContainer from "../containers/SectionContainer.vue";
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
};
</script>

<style lang="scss" scoped></style>
