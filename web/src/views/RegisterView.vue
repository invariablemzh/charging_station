<template>
  <ContentBase>
    <div class="row justify-content-md-center">
      <div class="col-3">
        <form @submit.prevent="register">
          <div class="mb-3">
            <label for="username" class="form-label">用户名</label>
            <input v-model="username" type="text" class="form-control" id="username">
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">密码</label>
            <input v-model="password" type="password" class="form-control" id="password">
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">确认密码</label>
            <input v-model="password_confirm" type="password" class="form-control" id="password">
          </div>
          <div class="error-message"> {{ error_message }} </div>
          <button type="submit" class="btn btn-primary">登录</button>
        </form>
      </div>
    </div>
    
  </ContentBase>
</template>

<script>
import ContentBase from '@/components/ContentBase'

export default {
  name: 'RegisterView',
  components: {
      ContentBase,
  }
}
</script>

<style scoped>
</style>