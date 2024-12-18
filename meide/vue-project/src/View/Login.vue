<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

const router = useRouter()
const username = ref('')
const password = ref('')

const handleLogin = () => {
    axios.post("http://localhost:8081/user/login", {
        account: username.value,
        pwd: password.value
    }).then(res => {
        if (res.data) {
            // 保存用户信息到 localStorage
            localStorage.setItem('user', JSON.stringify(res.data))
            router.push('/')
        } else {
            alert('用户名或密码错误')
        }
    }).catch(err => {
        alert('登录失败：' + err)
    })
}
</script>

<template>
    <div class="login-container">
        <div class="login-box">
            <h2>用户登录</h2>
            <div class="input-group">
                <input type="text" v-model="username" placeholder="用户名">
            </div>
            <div class="input-group">
                <input type="password" v-model="password" placeholder="密码">
            </div>
            <button @click="handleLogin">登录</button>
        </div>
    </div>
</template>

<style scoped>
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f4f4f4;
}

.login-box {
    background-color: white;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    width: 300px;
}

h2 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

.input-group {
    margin-bottom: 15px;
}

input {
    width: 100%;
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 10px;
    background-color: orangered;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #ff3300;
}
</style>
