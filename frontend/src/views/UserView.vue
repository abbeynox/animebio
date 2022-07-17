<template>
  <div class="card-container">
    <UserCard :user="user"/>
  </div>
</template>

<script>
import UserCard from "@/components/UserCard.vue";
export default {
  name: "UserInfoView",
  title: "User Info",
  data() {
    return {
      user: [],
      apiLoaded: false,
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
        this.loadUserInfo();
      },
      { immediate: true }
    );
  },
  methods: {
    async loadUserInfo() {
      let apiUrl = process.env.VUE_APP_USERAPI_BASEURL + "/user/" + this.id;
      console.log(apiUrl);
      try {
        let response = await this.axios.get(apiUrl);
        this.user = response.data[0];
        document.title = this.user.username + "🍭MyAnimeList";
      } catch (e) {
        console.log(e);
        this.error = true;
      }
    },
  },
  components: { UserCard },
};
</script>

<style lang="css" scoped>
.card-container {
  box-sizing: border-box;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
</style>
