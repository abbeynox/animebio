<template>
  <section-container sectionTitle="Popular" sectionIcon="bx bxs-hot">
    <vs-card-group>
      <vs-card
        v-for="anime in animes"
        :key="anime.mal_id"
        v-on:click="showDesc"
      >
        <template #title>
          <h3>{{ anime.title }}</h3>
        </template>
        <template #img>
          <img :src="anime.images.jpg.image_url" :alt="anime.title + ' img'" />
        </template>
        <template #text>
          <p id="anime-description">
            <span v-if="descOpened">{{ anime.background }}</span>
          </p>
        </template>
        <template #interactions>
          <vs-tooltip>
            <vs-button danger icon>
              <i class="bx bx-heart"></i>
            </vs-button>
            <template #tooltip> {{ anime.title }} speichern</template>
          </vs-tooltip>
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
  data() {
    return {
      loading: false,
      animes: [],
      error: false,
    };
  },
  created() {
    this.$watch(
      () => {
        this.loadAnimes();
      },
      { immediate: true }
    );
  },
  methods: {
    async loadAnimes() {
      this.loading = true;
      let apiUrl =
        process.env.VUE_APP_API_BASEURL + "/anime?order_by=popularity";
      try {
        let response = await this.axios.get(apiUrl);
        this.animes = response.data.data;
      } catch (e) {
        console.log(e);
        this.error = true;
      }
      this.loading = false;
    },
  },
  /*
  props: {
    mal_id: {
      type: Number,
      required: true,
    },
    title: {
      type: String,
      required: true,
      default: "Title",
    },
    background: {
      type: String,
      required: true,
      default: "Background",
    },
    image_url: {
      type: String,
      required: true,
      default: "http://localhost:8080/img/touka2.1221dd00.png",
    },
  },*/
};
</script>

<style lang="scss" scoped></style>
