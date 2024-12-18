<template>
    <header>
        <div class="w72 head grid">
            <img class="head-logo" src="../assets/logo.png" alt="">
            <div class="hidden">
                <input type="text" v-model="searchKey">  
                <button v-on:click="search()">搜索</button>  
            </div>
            <div v-if="!currentUser">
                <button class="login-btn" @click="goToLogin">登录</button>
            </div>
            <div v-else class="user-info">
                <span>欢迎，{{ currentUser.nickname }}</span>
                <button class="logout-btn" @click="handleLogout">退出登录</button>
            </div>
            <img src="../assets/search.png" class="head-search" alt="">
        </div>
    </header>

    <section class="w72">
        <div class="grid leibie">
            <div class="cell-1" @click="searchByCategory('经典著作')">
                <b>经典著作</b><br>
                <span>传世之作</span>
            </div>
            <div class="cell-1" @click="searchByCategory('社会科学')">
                <b>社会科学</b><br>
                <span>走近科学</span>
            </div>
            <div class="cell-1" @click="searchByCategory('技术')">
                <b>技术书籍</b><br>
                <span>技术进阶</span>
            </div>
            <div class="cell-1" @click="searchByCategory('生活')">
                <b>生活艺术</b><br>
                <span>品质生活</span>
            </div>
            <div class="cell-1" @click="searchByCategory('宠物')">
                <b>宠物饲养</b><br>
                <span>爱宠生活</span>
            </div>     
        </div>

        <div class="grid product">
            <div class="cell-1" v-for="item in books">
                <dl>
                    <dt><img v-bind:src="'http://localhost:8081/'+item.picture" alt=""></dt>
                    <dd>{{ item.bookName }}</dd>
                    <dd class="product-price">￥{{ item.price }}</dd>
                </dl>
            </div>
        </div>
    </section>

    <footer>
        京公网安备 11000002000088号 | 京ICP备11041704号 | ICP | 药品医疗器械网络服务备案 | 自营医疗器械经营资质 | 药品网络交易第三方平台备案凭证 | 新出发京零 字第大120007号
    </footer>
</template>

<script setup>
import axios from "axios";
import {ref, onMounted} from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const currentUser = ref(null)

onMounted(() => {
    // 从 localStorage 获取用户信息
    const userStr = localStorage.getItem('user')
    if (userStr) {
        currentUser.value = JSON.parse(userStr)
    }
})

const handleLogout = () => {
    localStorage.removeItem('user')
    currentUser.value = null
}

var books =ref([]);
var searchKey = ref("")

// 初始加载所有书籍
axios.get("http://localhost:8081/book/getbooks").then(
    (res)=>{
        console.log(res)
        books.value = res.data;
    }
).catch(
    (err) =>{alert(err);}
)

// 修改搜索函数支持关键词搜索
function search(){
    axios.get("http://localhost:8081/book/findByName",{params:{name:searchKey.value}}).then(
    (res)=>{
        books.value = res.data;
    }
).catch(
    (err) =>{alert(err);}
)
}

// 添加分类搜索函数
function searchByCategory(category) {
    let categoryMap = {
        "经典著作": ["西游记", "东游记"],
        "社会科学": ["新编大学计算机基础教程"],
        "技术": ["前端技术与架构与工程", "HarmonyOS NEXT启程：零基础"],
        "生活": ["四时园林"],
        "宠物": ["养一只快乐猫", "猫咪全阶段科学养护指南"]
    };
    
    axios.get("http://localhost:8081/book/getbooks").then(
        (res)=>{
            books.value = res.data.filter(book => categoryMap[category].includes(book.bookName));
        }
    ).catch(
        (err) =>{alert(err);}
    )
}

// 添加登录跳转方法
const goToLogin = () => {
    router.push('/login')
}
</script>

<style scoped>

*{
    margin: 0px;
    padding: 0px;
}

.grid{
    display: flex;
    justify-content: space-evenly;
}
.cell-1{
    flex-grow: 1;
}
.cell-2{
    flex-grow:2;
}
.cell-3{
    flex-grow: 3;
}
.cell-4{
    flex-grow: 4;
}
.cell-5{
    flex-grow: 5;
}
.cell-6{
    flex-grow: 6;
}

ul{
    list-style: none;
}

a{
    text-decoration: none;
}

 body{
            background-color: rgb(244, 244, 244);
        }
        .w72{
            width: 72%;
            margin: 0 auto;
        }

        /******************************* 页眉 ***************************/
        header{
            border-bottom: 1px solid orangered;
            background-color: white;
        }
        .head{
            height: 60px;
            align-items: center;
            justify-content:space-between;
        }
        .head-logo{
            height: 60px;
        }
        .head input{
            height: 30px;
            border:1px solid orangered;
            width: 300px;
        }
        .head button{
            height: 30px;
            border:none;
            margin-left: 5px;
            background-color: orangered;
            color: white;
            width: 50px;
        }
        .head-search{
            display: none;
        }
       
        /********************************** 类别 *************************/
        .leibie{
            margin-top: 10px;
        }
        .leibie>div{
            text-align: center;
            border-right: 1px solid grey;
            cursor: pointer;
        }
        .leibie>div:nth-of-type(6){
            border-right: 0px solid black;
        }
        .leibie>div:hover{
            color: orangered;
            /* background-color: seagreen; */
        }

        .leibie>div:hover span{
            color: orangered;
        }

        .leibie>div span{
            color: grey;
            font-size: 0.6em;
        }

        /********************************** 商品 *******************************/
        .product{
            flex-wrap: wrap;
            padding-top: 10px;
        }
        .product .cell-1{
            width: 18%;
            margin: 5px;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0px 0px 10px gray;
        }
        .product .cell-1:hover{
             box-shadow: 0px 0px 15px 5px orangered;
             
        }
        .product img{
            width: 100%;
            height: 230px;
        }
        .product dl{
            /* box-shadow: 0px 0px 10px 0px rgb(99, 99, 99);
            border-radius: 10px; */
            overflow: hidden;
            
        }
        .product dd{
            padding-left: 10px;
            color: rgb(92, 92, 92);
        }
        .product dd:nth-of-type(1){
            font-size: 0.9em;
        }
        .product dd:nth-of-type(2){
            color: red;
            font-weight: bold;
        }

        /*********************** 页脚 **************************/
        footer{
            text-align: center;
            margin-top: 10px;
            border-top: 1px solid gray;
            color: gray;
            font-size: 0.6em;
        }

        /********************* 平板端布局：最大宽度768px **********************/
        @media screen and (max-width:768px) {
             .w72{
                 width: 85%;
             }
             .product .cell-1{
               width: 45%;        
             }
             footer{
                 display: none;
             }
            
        }

        /********************* 手机端布局：最大宽度430px **********************/
        @media screen and (max-width:431px) {          
             .w72{
                 width: 100%;
             }
             .product .cell-1{
               width: 95%;        
             }
             footer,.hidden{
                 display: none;
             }
             .head-search{
                 display: block;
                 width: 30px;
                 height: 30px;
             }
        }

.login-btn {
    padding: 5px 15px;
    background-color: orangered;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100px !important;
}

.login-btn:hover {
    background-color: #ff3300;
}

.user-info {
    display: flex;
    align-items: center;
    gap: 10px;
}

.logout-btn {
    padding: 5px 15px;
    background-color: #666;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.logout-btn:hover {
    background-color: #444;
}
</style>