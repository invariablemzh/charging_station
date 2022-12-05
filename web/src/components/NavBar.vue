<template>
<nav class="navbar navbar-expand-lg navbar-light bg-success p-2 text-dark bg-opacity-75">
  <div class="container-fluid pianyi">
    <router-link class="navbar-brand text-white" :to="{name: 'home'}">绿色出行</router-link >
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link class="nav-link active text-white " :to="{name: 'home'}">首页</router-link >
        </li>
        <li class="nav-item">
          <router-link class="nav-link active text-white" :to="{name: 'chongdianzhuang'}">充电桩</router-link >
        </li>
      </ul>
       <!--<form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="搜索" aria-label="Search">
          <button class="btn btn-success text-nowrap" type="submit">搜索</button>
        </form> -->
        <ul class="navbar-nav" v-if="$store.state.user.is_login"> 
          <li class="nav-item dropdown pianyi">
            <a class="nav-link dropdown-toggle text-white" id="navbarDropdown" role="button" data-bs-toggle="dropdown" >
              {{ $store.state.user.username }}
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><router-link class="dropdown-item" :to="{name: 'orderlist'}">订单详情</router-link ></li>
              <li><router-link class="dropdown-item" :to="{name: 'payrecord'}">充值记录</router-link ></li>
              <li><a class="dropdown-item" href="#" @click="logout">退出</a ></li>
            </ul>
          </li>
          <li class="nav-item">
            <card class="nav-link active text-white" href="">余额: {{ $store.state.user.money }}</card >
          </li>    
        </ul> 

      <ul class="navbar-nav" v-else-if="!$store.state.user.pulling_info"> 
        <li class="nav-item">
          <router-link class="nav-link text-white" :to="{name: 'user_account_login'}">登录</router-link >
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-white" :to="{name: 'user_account_register'}">注册</router-link >
        </li>
      </ul>
      
    </div>
  </div>
</nav>
</template>



<script>
import { useRoute } from 'vue-router';
import { computed } from 'vue';
import { useStore } from 'vuex';

export default{
  name: 'NavBar',
  setup(){
    const store = useStore();
    const route = useRoute();
    let route_name = computed(() => route.name)

    const logout = () => {
      store.dispatch("logout");
    }
    return {
      route_name,
      logout,
    }
  }
}
</script>


<style scoped>

.pianyi{
  margin: 0px 20px;
}

</style>
