<template>
  <NavBar />
  <router-view> </router-view>

</template>

<script>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import NavBar from './components/NavBar.vue';

export default {
  name: "App",
  components:{
    NavBar,
  },
  setup(){
    
    // $.ajax({
    //   url: "http://localhost:3000/user/account/register/",
    //   type: "post",
    //   data:{
    //     username: "mzh2",
    //     password: "123456",
    //     confirmedPassword: "123456",
    //   },
    //   success(resp){
    //     console.log(resp);
    //   },
    //   error(resp){
    //     console.log(resp);
    //   },

    // });

  }
}

</script>

<style>
body{
  background-image: url("./assets/background.png");
  background-size: cover;
}

</style>
