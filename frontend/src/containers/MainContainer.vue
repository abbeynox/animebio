<template>
    <div class="main-container-border">
        <slot>
            View konnte nicht gerendert werden.
        </slot>
    </div>
</template>

<script>
    export default {
        name: 'MainContainer'
    }
</script>

<style lang="css" scoped>
.main-container-border {
    padding: 20px;
}
</style>