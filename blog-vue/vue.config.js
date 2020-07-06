// const isProduction = process.env.NODE_ENV === 'production'; //是否是生产环境
// const TerserPlugin = require('terser-webpack-plugin');  //压缩js的插件(需npm安装)
//在module.exports中修改配置
module.exports = {
  // outputDir: process.env.outputDir, //根据配置文件输出目录
  outputDir: 'dist',
  // productionSourceMap: !isProduction, //非生产环境才生成map文件
  // publicPath: isProduction ? './' : '/', //打包时区分开发环境与生产环境静态资源路径
  publicPath: './',
  // configureWebpack: config => {
  //   if (isProduction) {
  //     //正式生产环境删除debugger及console.log
  //     config.plugins.push(
  //         new TerserPlugin({
  //           terserOptions: {
  //             ecma: undefined,
  //             warnings: false,
  //             parse: {},
  //             compress: {
  //               drop_console: true,
  //               drop_debugger: true, //删除debugger
  //               pure_funcs: ['console.log'] // 移除console
  //             }
  //           }
  //         })
  //     );
  //   }
  // },
  // chainWebpack: config => {
  //   if (isProduction) {
  //     config.optimization.minimize(false); // 测试生产环境不压缩js代码
  //   }
  // },
  // 配置 webpack-dev-server 行为。
  devServer: {
    open: true,
    host: '0.0.0.0',
    port: 8080,
    https: false,
    hotOnly: false,
    proxy: {
      '/api': {
        target: 'http://localhost:8443',
        ws:true,
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  },
  // 三方插件的选项
  // pluginOptions: {
  //   // ...
  // }
}