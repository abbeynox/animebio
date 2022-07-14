<template>
  <section-container sectionTitle="Popular" sectionIcon="bx bxs-hot">
    <vs-card-group>
      <vs-card v-for="anime in animes" :key="anime.mal_id">
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
            <vs-button danger icon> <!-- Hier wird die ID ans Backend mitgeschickt-->
              <i class="bx bx-heart"></i>
            </vs-button>

            <template #tooltip> {{ anime.title }} speichern</template>
          </vs-tooltip>
          <vs-tooltip>
          <vs-button
            class="btn-chat"
            :disabled="anime.synopsis === null"
            @click="goToAnime(anime.mal_id)"
          >
            <span class="span"> Mehr Informationen </span>
          </vs-button>
           <template #tooltip v-if="anime.synopsis === null">Zu diesem Anime sind keine weiteren Informationen verfügbar</template>
           <template #tooltip v-else>Mehr Infos zu {{anime.title}}</template>
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
    goToAnime: function (id) {
      location.href = "/anime/" + id;
    },
    async loadAnimes() {
      this.loading = true;
      let apiUrl = process.env.VUE_APP_ANIMEAPI_BASEURL + "/anime?order_by=rank";
      try {
        let response = await this.axios.get(apiUrl);
        this.animes = response.data.data;
      } catch (e) {
        console.log(e);
        this.error = true;
      }
      this.loading = false;
    }
  }
};
</script>

<style lang="scss" scoped></style>
