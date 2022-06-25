import Vue from "vue";
import VuePageTitle from "vue-page-title";
import VueRouter from "vue-router";

Vue.use(VueRouter);

Vue.use(VuePageTitle, {
  suffix: "🍭MyAnimeList", // Website Titel falls kein anderes gefunden wurde
});
const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("@/views/HomeView.vue"),
  },
  {
    path: "/anime/:id",
    name: "single anime",
    component: () => import("@/views/AnimeInfoView.vue"),
    props: (route) => {
      const id = Number.parseInt(route.params.id);
      return { id };
    },
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
  routes: routes,
});

export default router;
