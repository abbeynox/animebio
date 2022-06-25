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
        <span class="duration">{{ anime.duration }}</span>
      </h4>
    </div>
    <div class="anime-description">
      <p v-if="anime.background !== null">
        {{ anime.background }}
      </p>
      <p v-if="anime.background == null">
      Zu diesem Anime ist keine Beschreibung verfügbar.</p>
    </div>
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
    async loadAnimeInfo() {
      let apiUrl =
        process.env.VUE_APP_API_BASEURL + "/anime/" + this.id + "/full";
      try {
        let response = await this.axios.get(apiUrl);
        this.anime = response.data.data;
        document.title = this.anime.title + "🍭MyAnimeList";
        // this.apiLoaded = true;
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
  margin: 80px auto;
  overflow: hidden;
  border-radius: 10px;
  box-shadow: 0px 0px 120px -25px rgba(0, 0, 0, 0.5);
  background: linear-gradient(to top, #e5e6e6 50%, transparent 100%);
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
  padding-right: 5px;
}
.duration {
  display: inline-block;
  color: #555;
  border-radius: 5px;
  padding-left: 5px;
  padding-right: 5px;
  border: 1px solid rgba(0, 0, 0, 0.05);
}
.anime-description {
  text-align: left;
}
.anime-img {
  position: relative;
  float: left;
  margin-right: 20px;
  height: 120px;
  box-shadow: 0 0 20px -10px rgba(0, 0, 0, 0.5);
}
</style>
