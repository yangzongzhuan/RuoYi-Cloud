<p align="center">
	<img alt="logo" src="https://oscimg.oschina.net/oscnet/up-b99b286755aef70355a7084753f89cdb7c9.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">RuoYi v3.6.7</h1>
<h4 align="center">基于 Vue/Element UI 和 Spring Boot/Spring Cloud & Alibaba 前后端分离的分布式微服务架构</h4>
<p align="center">
	<a href="https://gitee.com/y_project/RuoYi-Cloud/stargazers"><img src="https://gitee.com/y_project/RuoYi-Cloud/badge/star.svg?theme=dark"></a>
	<a href="https://gitee.com/y_project/RuoYi-Cloud"><img src="https://img.shields.io/badge/RuoYi-v3.6.7-brightgreen.svg"></a>
	<a href="https://gitee.com/y_project/RuoYi-Cloud/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>

## 平台简介

若依是一套全部开源的快速开发平台，毫无保留给个人及企业免费使用。

* 本仓库为RuoYi-Cloud的Spring Boot 3 的版本，保持同步更新。
* 后端采用Spring Boot3、Spring Cloud & Alibaba。
* 注册中心、配置中心选型Nacos，权限认证使用Redis。
* 流量控制框架选型Sentinel，分布式事务选型Seata。
* 提供了技术栈（Vue3 Element Plus Vite）的 [RuoYi-Cloud-Vue3](https://gitcode.com/yangzongzhuan/RuoYi-Cloud-Vue3)版本，以及技术栈（TypeScript）的 [RuoYi-Cloud-Vue3-TypeScript](https://gitcode.com/yangzongzhuan/RuoYi-Cloud-Vue3/tree/typescript)版本，两者保持同步更新。
* 阿里云优惠券：[点我进入](http://aly.ruoyi.vip)，腾讯云优惠券：[点我进入](http://txy.ruoyi.vip)&nbsp;&nbsp;

## 系统模块

~~~
com.ruoyi     
├── ruoyi-ui              // 前端框架 [80]
├── ruoyi-gateway         // 网关模块 [8080]
├── ruoyi-auth            // 认证中心 [9200]
├── ruoyi-api             // 接口模块
│       └── ruoyi-api-system                          // 系统接口
├── ruoyi-common          // 通用模块
│       └── ruoyi-common-core                         // 核心模块
│       └── ruoyi-common-datascope                    // 权限范围
│       └── ruoyi-common-datasource                   // 多数据源
│       └── ruoyi-common-log                          // 日志记录
│       └── ruoyi-common-redis                        // 缓存服务
│       └── ruoyi-common-seata                        // 分布式事务
│       └── ruoyi-common-security                     // 安全模块
│       └── ruoyi-common-sensitive                    // 数据脱敏
│       └── ruoyi-common-swagger                      // 系统接口
├── ruoyi-modules         // 业务模块
│       └── ruoyi-system                              // 系统模块 [9201]
│       └── ruoyi-gen                                 // 代码生成 [9202]
│       └── ruoyi-job                                 // 定时任务 [9203]
│       └── ruoyi-file                                // 文件服务 [9300]
├── ruoyi-visual          // 图形化管理模块
│       └── ruoyi-visual-monitor                      // 监控中心 [9100]
├──pom.xml                // 公共依赖
~~~

## 架构图

<img src="https://oscimg.oschina.net/oscnet/up-82e9722ecb846786405a904bafcf19f73f3.png"/>

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 在线构建器：拖动表单元素生成相应的HTML代码。
17. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

# 版本对比

RuoYi-Cloud 前端项目的三个主要演进版本，方便你直观对比其技术栈差异（并行开发维护）。

| 项目名称      | **RuoYi-Cloud** | **RuoYi-Cloud-Vue3** | **RuoYi-Cloud-Vue3-TypeScript**   |
| :---          | :---            | :---                 | :---                              |
| **前端框架**  | Vue 2           | Vue 3                | Vue 3                             |
| **脚本语言**  | JavaScript      | JavaScript           | TypeScript                        |
| **构建工具**  | Vue CLI         | Vite                 | Vite                              |
| **UI 组件库** | Element UI      | Element Plus         | Element Plus                      |
| **状态管理**  | Vuex            | Pinia                | Pinia                             |
| **路由管理**  | Vue Router 3    | Vue Router 4         | Vue Router 4                      |
| **核心特点**  | 1. 技术栈经典稳定<br>2. 社区资料丰富<br>3. 当前维护重心已转移 | 1. 现代前端技术栈<br>2. 开发体验与性能更优<br>3. 官方主推的活跃版本 | 1. 类型加持，减少沟通成本<br>2. 开发时有提示，效率更高<br>3. 多人协作企业级开发项目 |
| **仓库地址**  | [RuoYi-Cloud](https://gitee.com/y_project/RuoYi-Cloud) | [RuoYi-Cloud-Vue3](https://gitcode.com/yangzongzhuan/RuoYi-Cloud-Vue3) | [RuoYi-Cloud-Vue3-TypeScript](https://gitcode.com/yangzongzhuan/RuoYi-Cloud-Vue3/tree/typescript) |

## 在线体验

- admin/admin123  
- 陆陆续续收到一些打赏，为了更好的体验已用于演示服务器升级。谢谢各位小伙伴。

演示地址：http://ruoyi.vip  
文档地址：http://doc.ruoyi.vip

## 演示图

<table>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/cd1f90be5f2684f4560c9519c0f2a232ee8.jpg"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/1cbcf0e6f257c7d3a063c0e3f2ff989e4b3.jpg"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-8074972883b5ba0622e13246738ebba237a.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-9f88719cdfca9af2e58b352a20e23d43b12.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-39bf2584ec3a529b0d5a3b70d15c9b37646.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-4148b24f58660a9dc347761e4cf6162f28f.png"/></td>
    </tr>
	<tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-b2d62ceb95d2dd9b3fbe157bb70d26001e9.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-d67451d308b7a79ad6819723396f7c3d77a.png"/></td>
    </tr>	 
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/5e8c387724954459291aafd5eb52b456f53.jpg"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/644e78da53c2e92a95dfda4f76e6d117c4b.jpg"/></td>
    </tr>
	<tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-8370a0d02977eebf6dbf854c8450293c937.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-49003ed83f60f633e7153609a53a2b644f7.png"/></td>
    </tr>
	<tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-d4fe726319ece268d4746602c39cffc0621.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-c195234bbcd30be6927f037a6755e6ab69c.png"/></td>
    </tr>
	<tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-ece3fd37a3d4bb75a3926e905a3c5629055.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-92ffb7f3835855cff100fa0f754a6be0d99.png"/></td>
    </tr>
    <tr>
        <td><img src="https://oscimg.oschina.net/oscnet/up-ff9e3066561574aca73005c5730c6a41f15.png"/></td>
        <td><img src="https://oscimg.oschina.net/oscnet/up-5e4daac0bb59612c5038448acbcef235e3a.png"/></td>
    </tr>
</table>


## 若依微服务交流群

QQ群： [![加入QQ群](https://img.shields.io/badge/已满-42799195-blue.svg)](https://jq.qq.com/?_wv=1027&k=yqInfq0S) [![加入QQ群](https://img.shields.io/badge/已满-170157040-blue.svg)](https://jq.qq.com/?_wv=1027&k=Oy1mb3p8) [![加入QQ群](https://img.shields.io/badge/已满-130643120-blue.svg)](https://jq.qq.com/?_wv=1027&k=rvxkJtXK) [![加入QQ群](https://img.shields.io/badge/已满-225920371-blue.svg)](https://jq.qq.com/?_wv=1027&k=0Ck3PvTe) [![加入QQ群](https://img.shields.io/badge/已满-201705537-blue.svg)](https://jq.qq.com/?_wv=1027&k=FnHHP4TT) [![加入QQ群](https://img.shields.io/badge/已满-236543183-blue.svg)](https://jq.qq.com/?_wv=1027&k=qdT1Ojpz) [![加入QQ群](https://img.shields.io/badge/已满-213618602-blue.svg)](https://jq.qq.com/?_wv=1027&k=nw3OiyXs) [![加入QQ群](https://img.shields.io/badge/已满-148794840-blue.svg)](https://jq.qq.com/?_wv=1027&k=kiU5WDls) [![加入QQ群](https://img.shields.io/badge/已满-118752664-blue.svg)](https://jq.qq.com/?_wv=1027&k=MtBy6YfT) [![加入QQ群](https://img.shields.io/badge/已满-101038945-blue.svg)](https://jq.qq.com/?_wv=1027&k=FqImHgH2) [![加入QQ群](https://img.shields.io/badge/已满-128355254-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=G4jZ4EtdT50PhnMBudTnEwgonxkXOscJ&authKey=FkGHYfoTKlGE6wHdKdjH9bVoOgQjtLP9WM%2Fj7pqGY1msoqw9uxDiBo39E2mLgzYg&noverify=0&group_code=128355254) [![加入QQ群](https://img.shields.io/badge/已满-179219821-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=irnwcXhbLOQEv1g-TwGifjNTA_f4wZiA&authKey=4bpzEwhcUY%2FvsPDHvzYn6xfoS%2FtOArvZ%2BGXzfr7O0%2FEqLfkKA%2BuCDXlzHIFg8t93&noverify=0&group_code=179219821) [![加入QQ群](https://img.shields.io/badge/已满-158753145-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=lx1uEdEDuxeM7rUvF3qmlFdqKqdJ5Z-R&authKey=rgyPW9yhhh4IIURKVFa6NgP3qiqH04WAzrJ0trsgkr3pjzm6sKIOGyA58oOjoj%2FJ&noverify=0&group_code=158753145) [![加入QQ群](https://img.shields.io/badge/112869560-blue.svg)](http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=Kuaw0Xdlw2Nlgn6s8h9elzuquHGxGObD&authKey=cSrQcWQ%2BzQZAFFrwxaR%2BbzcumX4WRduZnd1O6JO1dlclQMiu%2BKwxAy8t2JfNp67V&noverify=0&group_code=112869560) 点击按钮入群。