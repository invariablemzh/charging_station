import $ from 'jquery'

export default {
    state: {
        id: "",
        username: "",
        token: "",
        money: 0,
        is_login: false,
        pulling_info: true, //是否正在拉去信息
    },  
    getters: {
    },
    mutations: {
        updateUser(state, user){
            state.id = user.id;
            state.username = user.username;
            state.money = user.money;
            state.is_login = user.is_login;
        },
        updateToken(state, token){
            state.token = token;
        },
        logout(state){
            state.id = "";
            state.username = "";
            state.password = "";
            state.money = 0;
            state.is_login = false;
        },
        updatePullingInfo(state, pulling_info){
            state.pulling_info = pulling_info;
        },
    },
    actions: {
        login(context, data){
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/token/",
                type: "post",
                data: {
                    username: data.username,
                    password: data.password,
                    money: data.money,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        localStorage.setItem("jwt_token", resp.token),
                        context.commit("updateToken", resp.token);
                        data.success(resp);
                        // $.ajax({
                        //     url:"http://127.0.0.1:3000/user/account/money/",
                        //     type: "get",
                        //     headers: {
                        //         Authorization: "Bearer " + store.state.user.token,
                        //     },
                        //     success(resp){
                        //         money.value = resp.money;
                        //         console.log(resp);
                        //     },
                        //     error(resp){
                        //       console.log(resp);
                        //     }
                        //   });
                    } else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                }
            });
            
        },
        getinfo(context, data){
            $.ajax({
                url: "http://localhost:3000/user/account/info/",
                type: "get",
                headers: {
                    Authorization: "Bearer " + context.state.token,
                },
                success(resp){
                    if(resp.error_message === "success"){
                        context.commit("updateUser",{
                            ...resp,
                            is_login: true,
                        });
                        data.success(resp);
                    } else{
                        data.error(resp);
                    }
                   
                },
                error(resp){
                    data.error(resp);
                },
            });
        },
        logout(context){
            localStorage.removeItem("jwt_token");
            context.commit("logout");
        }
    },
    modules: {
    }
}