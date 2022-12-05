<template>
  <div class="container">
    <div class="card">
        <div class="card-header">
          <span style="font-size: 130%">充电桩</span>
          <button v-if="($store.state.user.id==1||$store.state.user.id==2||$store.state.user.id==3)" type="button" class="btn btn-success float-end" data-bs-toggle="modal" data-bs-target="#add-charging-btn">
            创建充电桩
         </button>
         <!-- Modal -->
         <div class="modal fade" id="add-charging-btn" tabindex="-1">
          <div class="modal-dialog">
              <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title">创建充电桩</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <div class="mb-3">
                      <label for="add-charging-chargingState" class="form-label">充电状态(1:使用中,0:未使用)</label>
                      <input v-model="chargingadd.chargingState" type="text" class="form-control" id="add-charging-chargingState" placeholder="请输入充电桩的充电状态">
                  </div>
                  <div class="mb-3">
                      <label for="add-charging-runningState" class="form-label">运转状态(1:良好,0:故障)</label>
                      <input v-model="chargingadd.runningState" class="form-control" id="add-charging-runningState" rows="3" placeholder="请输入充电桩的运转状态">
                  </div>
                  <div class="mb-3">
                    <label for="add-charging-address" class="form-label">地址</label>
                    <textarea v-model="chargingadd.address" class="form-control" id="add-charging-address" rows="3" placeholder="请输入充电桩的地址"></textarea>
                </div>
                 
              </div>
              <div class="modal-footer">
                  <div class="error-message">{{ chargingadd.error_message }}</div>
                  <button type="button" class="btn btn-primary" @click="add_charging">创建</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
              </div>
              </div>
            </div>
         </div>
        </div>
        <div class="card-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">编号</th>
                <th scope="col">充电状态</th>
                <th scope="col">运转状态</th>
                <th scope="col">地址</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="charging in chargings" :key="charging.charging_id">
                <th>{{ charging.chargingId }}</th>
                <th v-if="(charging.chargingState==1)">使用中</th>
                <th v-else>未使用</th>
                <th v-if="(charging.runningState==1)">良好</th>
                <th v-else>故障</th>
                <th>{{ charging.address }}</th>
                <th>
                  <button v-if="($store.state.user.id==1||$store.state.user.id==2||$store.state.user.id==3)" type="button" class="btn btn-secondary" style="margin-right: 10px;" data-bs-toggle="modal" :data-bs-target="('#update-charging-modal-' + charging.chargingId)">修改</button>
                  <button v-if="($store.state.user.id==1||$store.state.user.id==2||$store.state.user.id==3)" type="button" class="btn btn-danger" style="margin-right: 10px;" @click="remove_charging(charging)">删除</button>
                  <button type="button" class="btn btn-success" style="margin-right: 10px;" data-bs-toggle="modal" :data-bs-target="('#use-charging-modal-' + charging.chargingId)">充电</button>

                  <div class="modal fade" :id="('update-charging-modal-' + charging.chargingId)" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">创建充电桩</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="add-charging-chargingState" class="form-label">充电状态(1:使用中,0:未使用)</label>
                                <input v-model="charging.chargingState" type="text" class="form-control" id="add-charging-chargingState" placeholder="请输入充电桩的充电状态">
                            </div>
                            <div class="mb-3">
                                <label for="add-charging-runningState" class="form-label">运转状态(1:良好,0:故障)</label>
                                <input v-model="charging.runningState" class="form-control" id="add-charging-runningState" rows="3" placeholder="请输入充电桩的运转状态">
                            </div>
                            <div class="mb-3">
                              <label for="add-charging-address" class="form-label">地址</label>
                              <textarea v-model="charging.address" class="form-control" id="add-charging-address" rows="3" placeholder="请输入充电桩的地址"></textarea>
                          </div>
                           
                        </div>
                        <div class="modal-footer">
                            <div class="error-message">{{ charging.error_message }}</div>
                            <button type="button" class="btn btn-primary" @click="update_charging(charging)">保存修改</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                        </div>
                        </div>
                      </div>
                   </div>



                   <div class="modal fade" :id="('use-charging-modal-' + charging.chargingId)" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">充电订单</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="use-charging-chargingId" class="form-label">充电桩编号: {{ charging.chargingId }}</label>
                            </div>
                            <div class="mb-3">
                              <label for="use-charging-chargingState" class="form-label">地址: {{ charging.address  }} </label>
                            </div>
                            <div class="mb-3">
                              <label for="use-charging-time" class="form-label"> 充电时长: </label>
                              <input v-model="charging.time" style="width:50px"  id="use-charging-time" >
                              <label for="use-charging-time" class="form-label"> 分钟 </label>
                            </div>
                            <div class="mb-3">
                              <label for="use-charging-money" class="form-label">金额: {{ (charging.time * 0.05).toFixed(2) }} 元</label>
                            </div>
                           
                        </div>
                        <div class="modal-footer">
                            <div class="error-message">{{ charging.error_message }}</div>
                            <button type="button" class="btn btn-success" @click="use_charging(charging)">开始充电</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                        </div>
                        </div>
                      </div>
                   </div>
                  

                </th>
              </tr>
            </tbody>
          </table>
  
        </div>
    </div>
</div>

</template>


<script>
import { ref,reactive } from 'vue';
import $ from 'jquery'
import { useStore } from 'vuex'
import { Modal } from 'bootstrap/dist/js/bootstrap'

export default{
  name: 'ChongDianZhuang',
  setup(){
    const store = useStore();
    let chargings = ref([]);

    const chargingadd = reactive({
      chargingState: "",
      runningState: "",
      address: "",
      error_message: "",
    });


    $.ajax({
      url: "http://127.0.0.1:3000/charging/getlist/",
      type: "get",
      headers: {
          Authorization: "Bearer " + store.state.user.token,
      },
      success(resp) {
        chargings.value = resp;
      },
    });

    const refresh_chargings = () => {
        $.ajax({
            url: "http://127.0.0.1:3000/charging/getlist/",
            type: "get",
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            success(resp) {
                chargings.value = resp;
            }
        })
    }

    refresh_chargings();

    const add_charging = () => {
            chargingadd.error_message = "";
            $.ajax({
                url: "http://127.0.0.1:3000/charging/add/",
                type: "post",
                data: {
                    chargingState: chargingadd.chargingState,
                    runningState: chargingadd.runningState,
                    address: chargingadd.address,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                  console.log(resp);
                    if (resp.error_message === "success") {
                        chargingadd.chargingState = "",
                        chargingadd.runningState = "",
                        chargingadd.address = "",
                        Modal.getInstance("#add-charging-btn").hide();
                        refresh_chargings();
                    } else {
                        chargingadd.error_message = resp.error_message;
                    }
                }
            })
        }


    const remove_charging = (charging) => {
        $.ajax({
            url: "http://127.0.0.1:3000/charging/delete/",
            type: "post",
            data: {
                chargingId: charging.chargingId,
            },
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            success(resp) {
                if (resp.error_message === "success") {
                    refresh_chargings();
                }
            }
        })
    }
    const update_charging = (charging) => {
            chargingadd.error_message = "";
            $.ajax({
                url: "http://127.0.0.1:3000/charging/update/",
                type: "post",
                data: {
                    chargingId: charging.chargingId,
                    chargingState: charging.chargingState,
                    runningState: charging.runningState,
                    address: charging.address,
                },
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        Modal.getInstance('#update-charging-modal-' + charging.chargingId).hide();
                        refresh_chargings();
                    } else {
                        charging.error_message = resp.error_message;
                    }
                }
            })
        }
      const use_charging = (charging) => {
          chargingadd.error_message = "";
          $.ajax({
              url: "http://127.0.0.1:3000/charging/using/",
              type: "post",
              data: {
                  chargingId: charging.chargingId,
                  chargingState: charging.chargingState,
                  runningState: charging.runningState,
                  time: charging.time,
                  money: (charging.time * 0.05).toFixed(2),
              },
              headers: {
                  Authorization: "Bearer " + store.state.user.token,
              },
              success(resp) {
                  console.log(resp);
                  if (resp.error_message === "success") {
                      Modal.getInstance('#use-charging-modal-' + charging.chargingId).hide();
                      refresh_chargings();
                      reload();
                  } else {
                      charging.error_message = resp.error_message;
                  }
              }
          })
      }
    return{
      chargings,
      refresh_chargings,
      add_charging,
      chargingadd,
      remove_charging,
      update_charging,
      use_charging,
    }
  }
}
</script>

<style scoped>
.container{
  margin-top:20px;
}

div.error-message {
  color: red;
}
</style>