import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../View/Layout.vue'
import Login from '../View/Login.vue'

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
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
