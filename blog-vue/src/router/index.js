import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from '../views/Login'

Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		name: 'Index',
		redirect: {name: 'Blog'}
	},
	{
		path: '/blogs',
		name: 'Blog',
		component: () => import("../views/Blog")
	},
	{
		path: '/login',
		name: 'Login',
		component: Login
	},
	{
		path: '/blog/:blogId',
		name: 'BlogDetail',
		component: () => import("../views/BlogDetail")
	},
	{
		path: '/blog/:blogId/edit',
		name: 'BlogEdit',
		component: () => import("../views/BlogEdit"),
		meta: {
			requireAuth: true //需要登录才能访问
		}
	},
	{
		path: '/blog/add',
		name: 'BlogAdd',
		component: () => import("../views/BlogEdit"),
		meta: {
			requireAuth: true //需要登录才能访问
		}
	},
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
