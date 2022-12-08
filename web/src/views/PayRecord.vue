<template>
  <ContentBase>
    充值记录
  </ContentBase>
  <div class="container">
    <div class="card">
        <div class="card-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">用户编号</th>
                <th scope="col">充值记录编号</th>
                <th scope="col">充值时间</th>
                <th scope="col">支付方式</th>
                <th scope="col">充值金额</th>
               
              </tr>
            </thead>
            <tbody>
              <tr v-for="chargingRecord in chargingRecords" :key="chargingRecord.recordId">
                <th>{{ chargingRecord.id }}</th>
                <th>{{ chargingRecord.recordId }}</th>
                <th>{{ chargingRecord.time }}</th>
                <th>{{ chargingRecord.payMethod }}</th>
                <th>{{ chargingRecord.money }}</th>
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
  name: 'PayRecord',
  components: {
    ContentBase,
  },
  setup(){
    const store = useStore();
    let chargingRecords = ref([]);
    $.ajax({
      url: "http://localhost:3000/chargingRecord/getlist/",
      type: "get",
      headers: {
          Authorization: "Bearer " + store.state.user.token,
      },
      success(resp){
        chargingRecords.value = resp;
      },
    });
    return{
      chargingRecords,
    }
  }
}
</script>

<style scoped>
.container{
  margin-top:20px;
}
</style>