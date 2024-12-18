import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../View/Layout.vue'
import Login from '../View/Login.vue'
import Register from '../View/Register.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: Layout
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    },
    {
        path: '/register',
        component: Register
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
