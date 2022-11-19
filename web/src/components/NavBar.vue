<template>
<nav class="navbar navbar-expand-lg navbar-light bg-success p-2 text-dark bg-opacity-75">
  <div class="container-fluid ">
    <a class="navbar-brand text-white" href="#">绿色出行</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-white" aria-current="page" href="#">首页</a>
        </li>
      </ul>
       <form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="搜索" aria-label="Search">
          <button class="btn btn-success text-nowrap" type="submit">搜索</button>
        </form>
      <ul class="navbar-nav" >
        <li class="nav-item">
          <a class="nav-link text-white" href="#">登录</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="#">注册</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</template>



<script>
export default{
  name: 'NavBar',
}
</script>


<style scoped>
.d-flex{
  margin: 0px 100px;
}



</style>
