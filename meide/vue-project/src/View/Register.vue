<template>
    <div class="register-container">
        <div class="register-box">
            <h2>用户注册</h2>
            <div class="form-group">
                <label>账号：</label>
                <input type="text" v-model="formData.account" placeholder="请输入账号">
            </div>
            <div class="form-group">
                <label>密码：</label>
                <input type="password" v-model="formData.pwd" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <label>昵称：</label>
                <input type="text" v-model="formData.nickname" placeholder="请输入昵称">
            </div>
            <div class="button-group">
                <button @click="handleRegister" class="register-btn">注册</button>
                <button @click="goToLogin" class="login-btn">返回登录</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const router = useRouter()
const formData = ref({
    account: '',
    pwd: '',
    nickname: '',
    type: 0 // 默认普通用户
})

const handleRegister = async () => {
    if (!formData.value.account || !formData.value.pwd || !formData.value.nickname) {
        alert('请填写完整信息')
        return
    }

    try {
        const response = await axios.post('http://localhost:8081/user/register', formData.value)
        if (response.data.success) {
            alert('注册成功！')
            router.push('/login')
        } else {
            alert(response.data.message || '注册失败')
        }
    } catch (error) {
        alert('注册失败：' + error.message)
    }
}

const goToLogin = () => {
    router.push('/login')
}
</script>

<style scoped>
.register-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f4f4f4;
}

.register-box {
    background-color: white;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 400px;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 5px;
    color: #666;
}

input {
    width: 100%;
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
}

.button-group {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
}

button {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 45%;
}

.register-btn {
    background-color: #28a745;
    color: white;
}

.login-btn {
    background-color: #666;
    color: white;
}

.register-btn:hover {
    background-color: #218838;
}

.login-btn:hover {
    background-color: #444;
}
</style>
