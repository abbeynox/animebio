<template>
  <div>
    <h1>{{ sectionTitle }}</h1>
    <p>{{ sectionDescription }}</p>
    <slot></slot>
  </div>
</template>

<script>
export default {
    name: 'SectionContainer',
    props: {
        sectionTitle: {
            type: String,
            required: true,
            default: "Title"
        },
        sectionDescription: {
            type: String,
            required: false
        }
    }
};
</script>

<style lang="css" scoped></style>
