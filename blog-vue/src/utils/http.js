import axios from 'axios'
import store from '../store'
// 引入element-ui依赖
import Element from 'element-ui'
import router from "../router";

// //创建axios实例，在这里可以设置请求的默认配置
// const instance = axios.create({
// 	baseURL: 'http://localhost:8443', //根据自己配置的反向代理去设置不同环境的baseUrl
// 	timeout: 10000, // 设置超时时间10s
// })

// 自定义全局请求头(后台)
axios.defaults.baseURL = "http://localhost:8443"

// 文档中的统一设置post请求头。
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

//请求拦截器
axios.interceptors.request.use(
		config => {
			// // 每次发送请求之前判断是否存在token，如果存在，则统一在http请求的header都加上token，不用每次请求都手动添加了
			// // 即使本地存在token，也有可能token是过期的，所以在响应拦截器中要对返回状态进行判断
			// const token = store.state.token;
			// token && (config.headers.Authorization = token);
			return config;
		},
		error => {
			return Promise.error(error);
		}
)

//响应拦截器
axios.interceptors.response.use(response => {
			let result = response.data

			console.log("-------------------------")
			console.log(result)
			console.log("-------------------------")

			if (result) {
				result.message = response.data.msg
			}
			if (result.code == 200) {
				//Element.Message.success("登录成功, 欢迎回来 !")
				Element.Message.success(result.message)
				return response //放行
			} else {
				//Element.Message.error('密码错误, 请尝试重新登录 !');
				Element.Message.error(result.message)
				return Promise.reject(response.data.msg)//抛出异常, 阻止进入"$axios.post(.."
			}
		},

		// 捕获并处理后台异常信息
		error => {
			// 使得异常信息更加友好
			if (error.response.data) { //data不为空时
				error.message = error.response.data.msg
				console.log("-------------------------")
				console.log(error.message)
				console.log("-------------------------")
			}

			if (error.response.status === 401) { //Shiro认证错误
				store.commit("REMOVE_INFO") //清除用户信息:token及userInfo
				router.push("/login") //跳转到登录页面
			}
			Element.Message.error(error.message);
			return Promise.reject(error)//抛出异常, 阻止进入"$axios.post(.."
		}
)
