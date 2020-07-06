import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../components/Login";
import AppIndex from "../components/home/AppIndex";
import Home from "../components/Home";
import LibraryIndex from "../components/library/LibraryIndex";

Vue.use(VueRouter)

  const routes = [
    // {
    //   path: '/',
    //   redirect: '/index'
    // },
    {
      path: '',
      redirect: '/login'//缺省时候重定向到/login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.VUE_APP_BASE_URL,
  routes
})

export default router
