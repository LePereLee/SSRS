<template>
  <div id="delete-student">
    <h1>删除学生 {{ student.name }}</h1>

    <p>
      <router-link :to="{ name: 'all_students' }"
        >返回学生信息列表页面</router-link
      >
    </p>

    <notification v-bind:notifications="notifications"></notification>

    <form v-on:submit.prevent="deleteStudent">
      <p><button class="btn btn-danger">删除学生</button></p>
    </form>
  </div>
</template>

<script>
import Notification from "./notifications.vue";

export default {
  data() {
    return {
      student: {},
      notifications: [],
    };
  },

  created: function () {
    this.student = this.$route.params.stu;
  },

  methods: {
    deleteStudent: function () {
      this.$http
        .delete("http://localhost:8090/student/" + this.student.stuNum, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            this.$router.push({ name: "all_students" });
          },
          (response) => {
            this.notifications.push({
              type: "danger",
              message: "学生信息无法删除",
            });
          }
        );
    },
  },

  components: {
    notification: Notification,
  },
};
</script>
