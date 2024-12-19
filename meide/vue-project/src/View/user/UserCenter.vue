<template>
    <div class="user-center">
        <div class="sidebar">
            <div class="menu-item" @click="$router.push('/user/profile')">个人资料</div>
            <div class="menu-item" @click="$router.push('/user/orders')">我的订单</div>
            <div class="menu-item" @click="$router.push('/user/settings')">账户设置</div>
        </div>
        <div class="content">
            <router-view></router-view>
        </div>
    </div>
</template>

<style scoped>
.user-center {
    display: flex;
    margin: 20px auto;
    max-width: 1200px;
}

.sidebar {
    width: 200px;
    background: #f5f5f5;
    padding: 20px;
}

.menu-item {
    padding: 10px;
    cursor: pointer;
    transition: all 0.3s;
}

.menu-item:hover {
    background: #e0e0e0;
    color: orangered;
}

.content {
    flex: 1;
    padding: 20px;
}
</style>