import Vue from 'vue'
import App from './App.vue'
import router from './router'
//引入状态管理store
import store from './store'

// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
const axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
//引入Element-UI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)


Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
      if (to.meta.requireAuth) {
        if (store.state.user.username) {
          next()
        } else {
          next({
            path: 'login',
            query: {redirect: to.fullPath}
          })
        }
      } else {
        next()
      }
    }
)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
