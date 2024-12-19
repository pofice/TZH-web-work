import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../View/Layout.vue'
import Login from '../View/Login.vue'
import Register from '../View/Register.vue'
import UserCenter from '../View/user/UserCenter.vue'
import UserProfile from '../components/user/UserProfile.vue'

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
    },
    {
        path: '/user',
        component: UserCenter,
        children: [
            {
                path: 'profile',
                component: UserProfile
            }
            // 可以继续添加其他子路由
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
