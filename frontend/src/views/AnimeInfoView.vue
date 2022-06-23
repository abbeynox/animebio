<template>
  <div>
    <p>Hier könnte eine Anime Info für {{ anime.title }} stehen</p>
    <vs-row w="12">
      <vs-col offset="1" w="3">
        <img
          :src="anime.images.jpg.image_url"
          :alt="'Vorschau von ' + anime.title"
        />
      </vs-col>
      <vs-col offset="1" w="7">
        <h1>{{ anime.title }}</h1>
      </vs-col>
    </vs-row>
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
    // openLoading() {
    //   const loading = this.$vs.loading({
    //     background: this.color,
    //     color: "#fff",
    //   });
    //   if (this.apiLoaded){
    //     loading.close();
    //   }
    // },
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

<style lang="scss" scoped></style>
