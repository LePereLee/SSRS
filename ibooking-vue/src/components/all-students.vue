<template>
  <div id="all_students">
    <h1>学生管理</h1>

    <p>
      <router-link :to="{ name: 'add_student' }" class="btn btn-primary"
        >添加学生信息</router-link
      >
    </p>

    <div class="form-group">
      <input
        type="text"
        name="search"
        v-model="studentSearch"
        placeholder="Search Students"
        class="form-control"
        v-on:keyup="searchStudents"
      />
    </div>

    <table class="table table-hover">
      <thead>
        <tr>
          <td>ID</td>
          <td>学号</td>
          <td>姓名</td>
          <td>操作</td>
        </tr>
      </thead>

      <tbody>
        <tr v-for="student in students">
          <td>{{ student.id }}</td>
          <td>{{ student.stuNum }}</td>
          <td>{{ student.name }}</td>
          <td>
            <router-link
              :to="{ name: 'edit_student', params: { stu: student } }"
              class="btn btn-primary"
              >修改</router-link
            >
            <router-link
              :to="{ name: 'delete_student', params: { stu: student } }"
              class="btn btn-danger"
              >删除</router-link
            >
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      students: [],
      originalStudents: [],
      studentSearch: "",
    };
  },

  created: function () {
    this.fetchStudentData();
  },

  methods: {
    fetchStudentData: function () {
      this.$http.get("http://127.0.0.1:8090/student").then(
        (response) => {
          this.students = response.body;
          this.originalStudents = this.students;
        },
        (response) => {}
      );
    },

    searchStudents: function () {
      if (this.studentSearch == "") {
        this.students = this.originalStudents;
        return;
      }

      var searchedStudents = [];
      for (var i = 0; i < this.originalStudents.length; i++) {
        var studentName = this.originalStudents[i]["name"].toLowerCase();
        if (studentName.indexOf(this.studentSearch.toLowerCase()) >= 0) {
          searchedStudents.push(this.originalStudents[i]);
        }
      }

      this.students = searchedStudents;
    },
  },
};
</script>
