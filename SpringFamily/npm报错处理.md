#### [npm i node-sass 报错&npm 镜像切换](https://www.cnblogs.com/ryans/p/7846562.html)

```
npm install --save node-sass --registry=https://registry.npm.taobao.org --disturl=https://npm.taobao.org/dist --sass-binary-site=http://npm.taobao.org/mirrors/node-sass
```



```
先把node_modules全部删除，然后再npm install chromedriver --chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver，最后npm install。
```

1. vue-cli 2.0构建项目  

   ```
   // 基于2.x的旧模式创建旧版vue项目
   npm install -g @vue/cli-init
   vue init webpack my project
   ```

   

2. vue-cli 3.0 构建项目

   ```
   npm install -g @vue/cli  						//安装cli
   vue create my-project							// 基于交互式命令行的方式创建新版vue项目
   ```

   

3. 安装cnpm

   ```powershell
   npm install -g cnpm --registry=https://registry.npm.taobao.org
   ```

   

4.  安装sass

   ```shell
   cnpm install sass-loader node-sass --save-dev 
   ```

5. 安装element-ui

   ```
   npm i element-ui -S
   ```

   

6. axios

   ```
   npm install axios -S
   ```

   

7. router

   ```
   npm install vue-router  --save-dev 
   ```

   



