<template>
  <div class="card-container">
    <img
      class="round"
      src="https://randomuser.me/api/portraits/women/79.jpg"
      alt="user"
    />
    <h3>{{ user.username }}</h3>
    <h6>Beigetreten am {{ dateTime(user.created_at) }}</h6>
    <p>{{ user.bio }}</p>

    <div class="skills">
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
  border: 1px solid #03bfcb;
  border-radius: 50%;
  padding: 7px;
}

button.primary {
  background-color: #03bfcb;
  border: 1px solid #03bfcb;
  border-radius: 3px;
  color: #231e39;
  font-family: Montserrat, sans-serif;
  font-weight: 500;
  padding: 10px 25px;
}

button.primary.ghost {
  background-color: transparent;
  color: #02899c;
}

.skills {
  text-align: left;
  padding: 15px;
  margin-top: 30px;
}

.skills ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.skills ul li {
  border: 1px solid #2d2747;
  border-radius: 2px;
  display: inline-block;
  font-size: 12px;
  margin: 0 7px 7px 0;
  padding: 7px;
}
</style>
