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


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/chongdianzhuang/',
    name: 'chongdianzhuang',
    component: ChongDianZhuang,
  },
  {
    path: '/account/',
    name: 'account',
    component: AccountView,
  },
  {
    path: '/orderlist/',
    name: 'orderlist',
    component: OrderList,
  },
  {
    path: '/buyrecord/',
    name: 'buyrecord',
    component: BuyRecord,
  },
  {
    path: '/payrecord/',
    name: 'payrecord',
    component: PayRecord,
  },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserAccountLoginView,
  },
  {
    path: "/user/account/register/",
    name: "user_account_register",
    component: UserAccountRegisterView,
  },
  {
    path: "/404/",
    name: "404",
    component: NotFound,
  },
  {
    path: "/:catchAll(.*)",
    redirect: "/404/"
  }
 
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
