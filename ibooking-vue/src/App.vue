<template>
  <div id="app">
    <p class="tab">
      <router-link to="/all_students" class="btn btn-primary"
        >学生管理</router-link
      >
      <router-link to="/all_studyrooms">自习室管理</router-link>
    </p>
    <router-view></router-view>
  </div>
</template>

<style>
    .fade-enter-active, .fade-leave-active {
      transition: opacity .5s
    }
    .fade-enter, .fade-leave-active {
      opacity: 0
    }
</style>

<script>
export default {
  name: "app",
};
</script>
