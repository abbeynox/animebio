<template>
  <div class="anime-card">
    <div class="anime-header">
      <img
        class="anime-img"
        :src="anime.images.jpg.image_url"
        :alt="'Vorschau von ' + anime.title"
      />
      <h1>{{ anime.title }}</h1>
      <div
        class="anime-genre"
        v-for="genre in anime.genres"
        v-bind:key="genre.mal_id"
      >
        <h4 class="anime-genre-name">{{ genre.name }}</h4>
      </div>
      <h4>
        {{ anime.aired.prop.from.year }}
        <span class="duration" v-if="anime.duration !== 'Unknown'">{{
          anime.duration
        }}</span>
      </h4>
    </div>
    <div class="anime-description">
      <p v-if="anime.synopsis !== null">
        {{ anime.synopsis }}
      </p>
      <p v-if="anime.synopsis == null">
        Zu diesem Anime ist keine Beschreibung verfügbar.
      </p>
    </div>
    <vs-button danger flat :active="active == 1" @click="active = 1">
      <i class="bx bxs-heart"></i><span>Auf meine Liste</span>
    </vs-button>
  </div>
</template>

<script>
export default {
  name: "AnimeInfoView",
  title: "Loading...",
  data() {
    return {
      anime: [],
      apiLoaded: false,
      color: "#7a76cb",
    };
  },
  props: {
    id: {
      type: Number,
      required: true,
    },
  },
  created() {
    this.$watch(
      () => {
        this.loadAnimeInfo();
      },
      { immediate: true }
    );
  },
  methods: {
    openLoading() {
      const loading = this.$vs.loading();
      setTimeout(() => {
        loading.close();
      }, 3000);
    },
    async loadAnimeInfo() {
      let apiUrl =
        process.env.VUE_APP_API_BASEURL + "/anime/" + this.id + "/full";
      try {
        let response = await this.axios.get(apiUrl);
        this.anime = response.data.data;
        document.title = this.anime.title + "🍭MyAnimeList";
      } catch (e) {
        console.log(e);
        this.error = true;
      }
    },
  },
};
</script>

<style lang="css" scoped>
.anime-card {
  padding: 10px;
  position: relative;
  display: block;
  width: 1000px;
  height: 400px;
  margin: 100px auto;
  overflow: hidden;
  border-radius: 10px;
  box-shadow: 0px 0px 150px -45px rgba(255, 0, 242, 0.5);
  background: linear-gradient(to right, #0d0d0c 50%, transparent 100%);
}
.anime-header {
  text-align: left;
  position: relative;
}
.anime-title {
  text-align: left;
  display: inline-block;
}
.anime-genre {
  display: inline-block;
}
.anime-genre .anime-genre-name {
  border: 1px solid rgba(0, 0, 0, 0.05);
  padding: 3px;
  margin: 3px;
  border-radius: 5px;
  color: #fff;
  background: #420080;
}
.duration {
  display: inline-block;
  margin-top: 10px;
  color: #fff;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid rgba(255, 255, 255, 0.13);
}
.anime-description {
  text-align: left;
  color: #cfd6e1;
}
.anime-img {
  position: relative;
  float: left;
  margin-right: 20px;
  height: 120px;
  box-shadow: 0 0 20px -10px rgba(0, 0, 0, 0.5);
}
</style>
