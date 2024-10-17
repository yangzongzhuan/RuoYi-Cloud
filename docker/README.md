# 部署 ruoyi cloud 流程

## 1. 安装依赖

1.1 安装 maven 依赖

```shell


mvn package


```

1.2 ruoyi-ui 依赖, 并打包

```shell


cd ruoyi-ui && npm i && npm run build:prod


```

## 2. 执行 copy.sh 将打包的 *.jar 和 dist 拷贝到制定文件中

## 3. 修改配置中的 localhost 为 真实 ip

### mysql 数据库没有初始化

> 创建 表结构 和 初始信息

```shell


# 需要在 ry-config 中执行
ry_config_xxx.sql


# 需要在 ry-cloud 中执行
ry_xxx.sql


```

### 修改 nacos 中的 localhost

> 首先在当前目录下的 .env 中修改环境变量 \
> 替换 nacos 管理的配置文件中的 localhost

1. 在容器中注入 LOCALHOST

```


...

    ruoyi-gateway:
      container_name: ruoyi-gateway
      build:
        context: ./ruoyi/gateway
        dockerfile: dockerfile
      ports:
        - "8080:8080"
      environment:
        RUOYI_NACOS: ruoyi-nacos
        LOCALHOST: ${LOCALHOST}         # 添加环境变量
      depends_on:
        - ruoyi-redis
      links:
        - ruoyi-redis

...


```

2. 在配置文件中使用注入的环境变量

> 修改前

```


spring:
  redis:
    host: localhost
    port: 6379
    password: 


```

> 修改后

```yaml


spring:
  redis:
    host: ${LOCALHOST:localhost}
    port: 6379
    password: 


```


#### 修改 nginx api 代理配置

> 修改前

```


location /prod-api/{
    proxy_set_header Host $http_host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header REMOTE-HOST $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_pass http://ruoyi-gateway:8080/;
}


```

> 修改后

```


location /prod-api/{
    proxy_set_header Host $http_host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header REMOTE-HOST $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_pass http://192.168.10.159:8080/;
}


```