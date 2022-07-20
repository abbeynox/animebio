<template>
  <div>
    <vs-dialog width="550px" not-center v-model="active">
      <template #header>
        <h4 class="not-margin">Dieser Benutzer existiert nicht</h4>
      </template>

      <div class="con-content">
        <p>
          Prüfe nach, ob du dich nicht vertippt hast und versuche es noch
          einmal.
        </p>
      </div>

      <template #footer>
        <div class="con-footer">
          <vs-button @click="active = false" transparent> Verstanden </vs-button>
        </div>
      </template>
    </vs-dialog>
  </div>
</template>

<script>
export default {
  name: "UserError",
  data() {
    return {
      active: Boolean,
    };
  },
  mounted() {
    this.active = true;
  }
};
</script>

<style lang="scss" scoped></style>
