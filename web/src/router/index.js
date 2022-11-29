import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RegisterView from '../views/RegisterView.vue'
import ChongDianZhuang from '../views/ChongDianZhuang.vue'
import AccountView from '../views/AccountView.vue'
import BuyRecord from '../views/BuyRecord.vue'
import OrderList from '../views/OrderList.vue'
import PayRecord from '../views/PayRecord.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/register/',
    name: 'register',
    component: RegisterView,
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
 
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
