<template>
  <div id="all_studyroom">
    <h1>自习室管理</h1>

    <p>
      <router-link :to="{ name: 'add_studyroom' }" class="btn btn-primary"
        >添加自习室</router-link
      >
    </p>

    <div class="form-group">
      <input
        type="text"
        name="search"
        v-model="studyRoomSearch"
        placeholder="Search Study Room"
        class="form-control"
        v-on:keyup="searchStudyRooms"
      />
    </div>

    <table class="table table-hover">
      <thead>
        <tr>
          <td>ID</td>
          <td>楼栋信息</td>
          <td>自习室信息</td>
        </tr>
      </thead>

      <tbody>
        <tr v-for="studyRoom in studyRooms">
          <td>{{ studyRoom.id }}</td>
          <td>{{ studyRoom.buildingNumber }}</td>
          <td>{{ studyRoom.classRoomNumber }}</td>
          <td>
            <router-link
              :to="{ name: 'edit_studyRoom', params: { stu: studyRoom } }"
              class="btn btn-primary"
              >修改</router-link
            >
            <router-link
              :to="{ name: 'delete_studyRoom', params: { stu: studyRoom } }"
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
      studyRooms: [],
      originalStudyRooms: [],
      studyRoomsSearch: "",
    };
  },

  created: function () {},

  methods: {},
};
</script>
