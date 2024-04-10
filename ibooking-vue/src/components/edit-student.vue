<template>
  <div id="edit-student">
    <h1>学生信息 {{ student.name }} 修改</h1>

    <p>
      <router-link :to="{ name: 'all_students' }"
        >返回学生信息列表页面</router-link
      >
    </p>

    <notification v-bind:notifications="notifications"></notification>

    <form v-on:submit.prevent="editStudent">
      <div class="form-group">
        <label name="student_id">ID</label>
        <input
          type="text"
          class="form-control"
          disabled
          v-model="student.id"
          id="student_id"
        />
      </div>

      <div class="form-group">
        <label name="student_number">学号</label>
        <input
          type="text"
          class="form-control"
          v-model="student.stuNum"
          id="student_number"
          required
        />
      </div>

      <div class="form-group">
        <label name="student_name">姓名</label>
        <input
          type="text"
          class="form-control"
          v-model="student.name"
          id="student_name"
          required
        />
      </div>

      <div class="form-group">
        <label name="student_password">密码</label>
        <input
          type="password"
          class="form-control"
          v-model="student.password"
          id="student_password"
          required
        />
      </div>

      <div class="form-group">
        <button class="btn btn-primary">提交</button>
      </div>
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
    this.getStudent();
  },

  methods: {
    getStudent: function () {
      this.student = this.$route.params.stu;
    },

    editStudent: function () {
      this.$http
        .put("http://localhost:8090/student", this.student, {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then(
          (response) => {
            this.notifications.push({
              type: "success",
              message: "学生信息修改成功",
            });
          },
          (response) => {
            this.notifications.push({
              type: "error",
              message: "学生信息修改失败",
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
