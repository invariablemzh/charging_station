import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserAccountLoginView from '../views/user/account/UserAccountLoginView.vue'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView.vue'
import ChongDianZhuang from '../views/ChongDianZhuang.vue'
import AccountView from '../views/AccountView.vue'
import BuyRecord from '../views/BuyRecord.vue'
import OrderList from '../views/OrderList.vue'
import PayRecord from '../views/PayRecord.vue'
import NotFound from '../views/error/NotFound.vue'
import store from '../store/index'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/chongdianzhuang/',
    name: 'chongdianzhuang',
    component: ChongDianZhuang,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/account/',
    name: 'account',
    component: AccountView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/orderlist/',
    name: 'orderlist',
    component: OrderList,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/buyrecord/',
    name: 'buyrecord',
    component: BuyRecord,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/payrecord/',
    name: 'payrecord',
    component: PayRecord,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/user/account/register/",
    name: "user_account_register",
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/404/",
    name: "404",
    component: NotFound,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/:catchAll(.*)",
    redirect: "/404/",
    meta: {
      requestAuth: false,
    }
  }
 
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if(to.meta.requestAuth && !store.state.user.is_login){
    next({name: "user_account_login"})
  } else {
    next();
  }
})

export default router
