import Vue from 'vue'
import App from './App.vue'
//路由
import router from './router'
//引入状态管理store
import store from './store'
// 引入axios依赖
import axios from 'axios'
// axios全局使用
Vue.prototype.$axios = axios
// 引入自定义http.js
import "./utils/http"
// 引入permission(路由权限拦截)
import "./utils/permission"
//引入Element-UI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入mavon-editor
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
// 引入'复制内容至剪切板'插件
import VueClipboards from 'vue-clipboard2'

// mavon-editor全局使用
Vue.use(mavonEditor)
// VueClipboards全局使用
Vue.use(VueClipboards);
// element-ui全局使用
Vue.use(ElementUI)


Vue.config.productionTip = false


new Vue({
	router,
	store,
	render: h => h(App)
}).$mount('#app')
