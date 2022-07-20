<template>
  <div class="card-container">
    <img
      class="round"
      :src="'https://api.multiavatar.com/' + this.user.username + '.png?apikey=x5vsuy62F1RQwX'"
      width="120px"
      alt="user"
    />
    <h3>{{ user.username }}</h3>
    <h6>Beigetreten am {{ dateTime(user.created_at) }}</h6>
    <p>{{ user.bio }}</p>

    <div class="animes">
      <h6>Gespeicherte Anime</h6>
      <ul>
        <li>Attack on Titan</li>
        <li>Deathnote</li>
        <li>One Piece</li>
        <li>Erased</li>
        <li>Tokyo Revengers</li>
        <li>Tokyo Ghoul</li>
      </ul>
    </div>
  </div>
</template>

<script>
import moment from "moment";
export default {
  name: "UserCard",
  data() {
    return {
      avatar: String,
    };
  },

  methods: {
    dateTime(value) {
      return moment(value).format("DD. MMMM YYYY, HH:MM");
    },
  },
  props: {
    user: {
      type: Array,
    },
  },
};
</script>

<style lang="css" scoped>
h3 {
  margin: 10px 0;
}

h6 {
  margin: 5px 0;
  text-transform: uppercase;
}

p {
  font-size: 14px;
  line-height: 21px;
}

.card-container {
  border-radius: 5px;
  color: #b3b8cd;
  position: relative;
  width: 350px;
  max-width: 100%;
  text-align: center;
  padding-top: 80px;
}

.card-container .round {
  border: 1px solid #420080;
  border-radius: 50%;
  padding: 7px;
}

.animes {
  text-align: left;
  padding: 15px;
  margin-top: 30px;
}

.animes ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.animes ul li {
  border: 1px solid #2d2747;
  border-radius: 2px;
  display: inline-block;
  font-size: 12px;
  margin: 0 7px 7px 0;
  padding: 7px;
}
</style>
