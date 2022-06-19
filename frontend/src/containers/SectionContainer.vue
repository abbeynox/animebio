<template>
  <div class="section-container-border">
    <h1 class="section-title"><i :class="sectionIcon"></i> {{ sectionTitle }}</h1>
    <p class="section-description">{{ sectionDescription }}</p>
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: "SectionContainer",
  props: {
    sectionTitle: {
      type: String,
      required: true,
      default: "Title",
    },
    sectionDescription: {
      type: String,
      required: false,
    },
    sectionIcon: { // Bitte Boxicons benutzen
      type: String,
      required: false,
    },
  },
};
</script>

<style lang="css" scoped>
.section-title {
  text-align: left;
}
.section-container-border {
  margin-top: 20pcx;
  margin-left: 10%;
  margin-right: 10%;
}
</style>
