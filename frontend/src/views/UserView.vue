<template>
  <div>
    <p>Das hier ist die User Info für den User mit ID {{ this.id }}</p>
  </div>
</template>

<script>
export default {
  name: "UserInfoView",
  title: "User Info",
  props: {
    id: {
      type: Number,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped></style>
