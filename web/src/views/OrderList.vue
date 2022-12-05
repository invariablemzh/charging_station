<template>
  <ContentBase>
    订单详情
  </ContentBase>
  <div class="container">
    <div class="card">
        <div class="card-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">订单编号</th>
                <th scope="col">充电桩编号</th>
                <th scope="col">开始时间</th>
                <th scope="col">结束时间</th>
                <th scope="col">持续时间</th>
                <th scope="col">付款方式</th>
                <th scope="col">花费的金额</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="orderlist in orderlists" :key="orderlist.orderId">
                <th>{{ orderlist.orderId }}</th>
                <th>{{ orderlist.chargingId }}</th>
                <th>{{ orderlist.startTime }}</th>
                <th>{{ orderlist.endingTime }}</th>
                <th>{{ orderlist.lastingTime }}</th>
                <th>{{ orderlist.payMethod }}</th>
                <th>{{ orderlist.money }}</th>
              </tr>
            </tbody>
          </table>
  
        </div>
    </div>
</div>
</template>


<script>
import ContentBase from '@/components/ContentBase.vue';
import $ from 'jquery';
import { useStore } from 'vuex';
import { ref } from 'vue';

export default{
  name: 'OrderList',
  components: {
    ContentBase,
  },
  setup(){
    const store = useStore();
    let orderlists = ref([]);
    $.ajax({
      url: "http://localhost:3000/orderlist/getlist/",
      type: "get",
      headers: {
          Authorization: "Bearer " + store.state.user.token,
      },
      success(resp){
        orderlists.value = resp;
      },
    });
    return{
      orderlists,
    }
  }
  

}
</script>

<style scoped>
.container{
  margin-top:20px;
}
</style>