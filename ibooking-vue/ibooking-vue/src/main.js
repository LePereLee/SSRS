import Vue from 'vue'

import VueRouter from 'vue-router'
Vue.use(VueRouter)

import VueResource from 'vue-resource';
Vue.use(VueResource);

import App from './App.vue'

const AllStudents = require('./components/all-students.vue');
const AddStudent = require('./components/add-student.vue');
const EditStudent = require('./components/edit-student.vue');
const DeleteStudent = require('./components/delete-student.vue');
const AllStudyRooms = require('./components/all-studyrooms.vue');

const routes = [
    {
        name: 'all_students',
        path: '/',
        component: AllStudents
    },
    {
        name: 'all_students',
        path: '/all_students',
        component: AllStudents
    },
    {
        name: 'add_student',
        path: '/student/add-student',
        component: AddStudent
    },
    {
        name: 'edit_student',
        path: '/student/edit/:stu',
        component: EditStudent
    },
    {
        name: 'delete_student',
        path: '/student/delete/:stu',
        component: DeleteStudent
    },
    {
        name: 'all_studyrooms',
        path: '/all_studyrooms',
        component: AllStudyRooms
    }
];
var router = new VueRouter({ routes: routes, mode: 'history' });
new Vue(Vue.util.extend({ router }, App)).$mount('#app');