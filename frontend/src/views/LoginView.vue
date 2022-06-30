<template>
  <div>
    <div class="center content-inputs">
      <vs-input v-model="username" placeholder="Benutzername">
        <template #icon>
          <i class="bx bx-user"></i>
        </template>
      </vs-input>

      <vs-input
        type="password"
        icon-after
        v-model="password"
        placeholder="Passwort"
      >
        <template #icon>
          <i class="bx bx-lock-open-alt"></i>
        </template>
      </vs-input>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginView",
  title: "Login",
};
</script>

<style lang="scss" scoped></style>
