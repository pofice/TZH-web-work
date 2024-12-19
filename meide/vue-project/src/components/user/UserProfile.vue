<template>
    <div class="profile">
        <h2>个人资料</h2>
        <div class="profile-info">
            <p>用户名：{{ currentUser?.username }}</p>
            <p>昵称：{{ currentUser?.nickname }}</p>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const currentUser = ref(null)

onMounted(() => {
    const userStr = localStorage.getItem('user')
    if (userStr) {
        currentUser.value = JSON.parse(userStr)
    }
})
</script>

<style scoped>
.profile {
    padding: 20px;
}

.profile-info {
    margin-top: 20px;
}

.profile-info p {
    margin: 10px 0;
}
</style>