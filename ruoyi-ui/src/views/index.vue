<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 14px">
          领取阿里云通用云产品1888优惠券
          <br />
          <el-link
            href="https://www.aliyun.com/minisite/goods?userCode=brki8iof"
            type="primary"
            target="_blank"
            >https://www.aliyun.com/minisite/goods?userCode=brki8iof</el-link
          >
          <br />
          领取腾讯云通用云产品2860优惠券
          <br />
          <el-link
            href="https://cloud.tencent.com/redirect.php?redirect=1025&cps_key=198c8df2ed259157187173bc7f4f32fd&from=console"
            type="primary"
            target="_blank"
            >https://cloud.tencent.com/redirect.php?redirect=1025&cps_key=198c8df2ed259157187173bc7f4f32fd&from=console</el-link
          >
          <br />
          阿里云服务器折扣区
          <el-link href="http://aly.ruoyi.vip" type="primary" target="_blank"
            >>☛☛点我进入☚☚</el-link
          >
          &nbsp;&nbsp;&nbsp; 腾讯云服务器秒杀区
          <el-link href="http://txy.ruoyi.vip" type="primary" target="_blank"
            >>☛☛点我进入☚☚</el-link
          ><br />
          <h4 class="text-danger">
            云产品通用红包，可叠加官网常规优惠使用。(仅限新用户)
          </h4>
        </blockquote>

        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>若依后台管理框架</h2>
        <p>
          一直想做一款后台管理系统，看了很多优秀的开源项目但是发现没有合适自己的。于是利用空闲休息时间开始自己写一套后台系统。如此有了若依管理系统，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。所有前端后台代码封装过后十分精简易上手，出错概率低。同时支持移动客户端访问。系统会陆续更新一些实用功能。
        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>
        <p>
          <el-tag type="danger">&yen;免费开源</el-tag>
        </p>
        <p>
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-cloudy"
            plain
            @click="goTarget('https://gitee.com/y_project/RuoYi-Cloud')"
            >访问码云</el-button
          >
          <el-button
            size="mini"
            icon="el-icon-s-home"
            plain
            @click="goTarget('http://ruoyi.vip')"
            >访问主页</el-button
          >
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>SpringCloud</li>
              <li>Nacos</li>
              <li>Sentinel</li>
              <li>Seata</li>
              <li>Minio</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Echarts</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 官网：<el-link
                href="http://www.ruoyi.vip"
                target="_blank"
                >http://www.ruoyi.vip</el-link
              >
            </p>
            <p>
              <i class="el-icon-user-solid"></i> QQ群：<s>满42799195</s>
              <s>满170157040</s> <s>满130643120</s> <s>满225920371</s>
              <s>满201705537</s> <s>满236543183</s> <s>满213618602</s>
              <s>满148794840</s> <s>满118752664</s>
              <a href="https://jq.qq.com/?_wv=1027&k=FqImHgH2" target="_blank"
                >101038945</a
              >
            </p>
            <p>
              <i class="el-icon-chat-dot-round"></i> 微信：<a
                href="javascript:;"
                >/ *若依</a
              >
            </p>
            <p>
              <i class="el-icon-money"></i> 支付宝：<a
                href="javascript:;"
                class="支付宝信息"
                >/ *若依</a
              >
            </p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v3.6.3 - 2023-07-07">
              <ol>
                <li>支持登录IP黑名单限制</li>
                <li>操作日志新增消耗时间属性</li>
                <li>屏蔽定时任务bean违规的字符</li>
                <li>日志管理使用索引提升查询性能</li>
                <li>日志注解支持排除指定的请求参数</li>
                <li>支持自定义隐藏属性列过滤子对象</li>
                <li>升级spring-boot到最新版本2.7.13</li>
                <li>升级spring-cloud到最新版2021.0.8</li>
                <li>升级spring-cloud-alibaba到最新版2021.0.5.0</li>
                <li>升级druid到最新版本1.2.16</li>
                <li>升级fastjson到最新版2.0.34</li>
                <li>升级pagehelper到最新版1.4.7</li>
                <li>升级transmittable-thread-local到最新版本2.14.3</li>
                <li>升级element-ui到最新版本2.15.13</li>
                <li>移除apache/commons-fileupload依赖</li>
                <li>修复页面切换时布局错乱的问题</li>
                <li>修复用户多角色数据权限可能出现权限抬升的情况</li>
                <li>修复导入用户时无法更新存在用户数据的问题</li>
                <li>修复开启TopNav后一级菜单路由参数设置无效问题</li>
                <li>优化文件下载出现的异常</li>
                <li>优化选择图标组件高亮回显</li>
                <li>优化修改密码日志存储明文问题</li>
                <li>优化排序属性orderBy参数限制长度</li>
                <li>优化页签栏关闭其他出现的异常问题</li>
                <li>优化页签关闭左侧选项排除首页选项</li>
                <li>优化关闭当前tab页跳转最右侧tab页</li>
                <li>优化文件上传服务关闭InputStream</li>
                <li>优化页签在Firefox浏览器被遮挡的问题</li>
                <li>优化侧边栏的平台标题与VUE_APP_TITLE保持同步</li>
                <li>优化DictTag组件value没有匹配的值时则展示value</li>
                <li>优化去除@EnableCustomSwagger注解后会启动失败问题</li>
                <li>优化upload接口在文件过大和文件名过长的情况返回提示信息</li>
                <li>优化异步保存日志发生报错不进RemoteLogFallbackFactory问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.6.2 - 2023-01-16">
              <ol>
                <li>重置时取消部门选中</li>
                <li>新增返回警告消息提示</li>
                <li>忽略不必要的属性数据返回</li>
                <li>修改参数键名时移除前缓存配置</li>
                <li>开启TopNav没有子菜单隐藏侧边栏</li>
                <li>删除fuse无效选项maxPatternLength</li>
                <li>兼容Excel下拉框内容过多无法显示的问题</li>
                <li>修复文件上传组件格式验证问题</li>
                <li>修复回显数据字典数组异常问题</li>
                <li>修复sheet超出最大行数异常问题</li>
                <li>修复Log注解GET请求记录不到参数问题</li>
                <li>修复gateway流控规则生效但不显示问题</li>
                <li>修复主题颜色在Drawer组件不会加载问题</li>
                <li>修复调度日志点击多次数据不变化的问题</li>
                <li>修复用户编辑时角色和部门存在无法修改情况</li>
                <li>修复使用透明底png图片时，自动填充黑色背景</li>
                <li>修复table中更多按钮切换主题色未生效修复问题</li>
                <li>修复某些特性的环境生成代码变乱码TXT文件问题</li>
                <li>修复代码生成图片/文件/单选时选择必填无法校验问题</li>
                <li>升级spring-cloud到最新版2021.0.5</li>
                <li>升级spring-boot到最新版本2.7.7</li>
                <li>升级spring-boot-admin到最新版2.7.10</li>
                <li>升级kaptcha到最新版2.3.3</li>
                <li>升级druid到最新版本1.2.15</li>
                <li>升级fastjson到最新版2.0.22</li>
                <li>升级pagehelper到最新版1.4.6</li>
                <li>升级transmittable-thread-local到最新版本2.14.2</li>
                <li>升级echarts到最新版本5.4.0</li>
                <li>升级core-js到最新版本3.25.3</li>
                <li>升级element-ui到最新版本2.15.12</li>
                <li>移除commons-collections多余的依赖</li>
                <li>优化弹窗内容过多展示不全问题</li>
                <li>优化导出对象的子列表为空会出现[]问题</li>
                <li>优化字符未使用下划线不进行驼峰式处理</li>
                <li>优化nacos修改xss开关时同步过滤器验证</li>
                <li>优化修改头像在小屏幕上页面布局错位的问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.6.1 - 2022-10-01">
              <ol>
                <li>数据逻辑删除不进行唯一验证</li>
                <li>支持多权限字符匹配角色数据权限</li>
                <li>页面内嵌iframe切换tab不刷新数据</li>
                <li>新增密码最大错误次数/锁定时间</li>
                <li>登录日志新增解锁账户功能</li>
                <li>通用下载方法新增config配置选项</li>
                <li>操作日志记录支持排除敏感属性字段</li>
                <li>Excel注解支持导出对象的子列表方法</li>
                <li>Excel注解支持自定义隐藏属性列</li>
                <li>Excel注解支持backgroundColor属性设置背景色</li>
                <li>升级spring-cloud-alibaba到最新版2021.0.4.0</li>
                <li>升级spring-cloud到最新版2021.0.4</li>
                <li>升级spring-boot到最新版本2.7.3</li>
                <li>升级spring-boot-admin到最新版2.7.5</li>
                <li>升级seata到最新版1.5.2</li>
                <li>升级druid到最新版本1.2.12</li>
                <li>升级fastjson到最新版2.0.14</li>
                <li>升级pagehelper到最新版1.4.5</li>
                <li>升级core-js到最新版本3.25.2</li>
                <li>升级dynamic-ds到最新版本3.5.2</li>
                <li>升级element-ui到最新版本2.15.10</li>
                <li>修复多文件上传报错出现的异常问题</li>
                <li>修复图片预览组件src属性为null值控制台报错问题</li>
                <li>修复使用FastDFS上传头像失败提示文件名没有后缀问题</li>
                <li>优化seata单独依赖模块</li>
                <li>优化任务过期不执行调度</li>
                <li>优化字典数据使用store存取</li>
                <li>优化代码生成同步后值NULL问题</li>
                <li>优化定时任务支持执行父类方法</li>
                <li>优化修改资料头像被覆盖的问题</li>
                <li>优化修改用户登录账号重复验证</li>
                <li>优化用户个人信息接口防止修改部门</li>
                <li>优化布局设置使用el-drawer抽屉显示</li>
                <li>优化日志注解记录限制请求地址的长度</li>
                <li>优化导入更新用户数据前校验数据权限</li>
                <li>优化excel/scale属性导出单元格数值类型</li>
                <li>优化日志操作中重置按钮时重复查询的问题</li>
                <li>优化多个相同角色数据导致权限SQL重复问题</li>
                <li>优化表格上右侧工具条（搜索按钮显隐&右侧样式凸出）</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.6.0 - 2022-07-16">
              <ol>
                <li>Excel注解支持color字体颜色</li>
                <li>用户头像上传限制只能为图片格式</li>
                <li>检查定时任务bean所在包名是否为白名单配置</li>
                <li>字典类型必须以字母开头，且只能为（小写字母，数字，下滑线）</li>
                <li>升级spring-cloud-alibaba到最新版2021.0.1.0</li>
                <li>升级spring-cloud到最新版2021.0.3</li>
                <li>升级spring-boot到最新版本2.7.1</li>
                <li>升级spring-boot-admin到最新版2.7.2</li>
                <li>升级seata到最新版1.5.1</li>
                <li>升级pagehelper到最新版1.4.3</li>
                <li>升级dynamic-ds到最新版本3.5.1</li>
                <li>升级fastjson到最新版2.0.9</li>
                <li>升级druid到最新版本1.2.11</li>
                <li>升级transmittable-thread-local到最新版本2.13.2</li>
                <li>升级element-ui到最新版本2.15.9</li>
                <li>修复字典数据显示不全问题</li>
                <li>修复操作日志查询类型条件为0时会查到所有数据</li>
                <li>优化验证码开关变量名</li>
                <li>优化设置分页参数默认值</li>
                <li>优化对空字符串参数处理的过滤</li>
                <li>优化Maven使用阿里云镜像站加速</li>
                <li>优化用户列表查询不显示密码字段</li>
                <li>优化表单构建按钮不显示正则校验</li>
                <li>优化字典类型删除多余的mapper注解</li>
                <li>优化字典数据回显样式下拉框显示值</li>
                <li>优化用户管理左侧树型组件增加选中高亮保持</li>
                <li>优化新增用户与角色信息&用户与岗位信息逻辑</li>
                <li>优化数据监控Spring Security权限认证过时代码</li>
                <li>优化岗位长主键溢出问题将查询返回类型改为Long</li>
                <li>优化删除无用admin-client依赖声明，避免造成误解</li>
                <li>优化默认不启用压缩文件缓存防止node_modules过大</li>
                <li>优化获取body请求数据缓存过滤器CacheRequestFilter</li>
                <li>优化网关通过注解解决循环引用及Bean重复问题删除allow配置</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.5.0 - 2022-04-11">
              <ol>
                <li>开启TopNav没有子菜单情况隐藏侧边栏</li>
                <li>侧边栏菜单名称过长悬停显示标题</li>
                <li>用户访问控制时校验数据权限，防止越权</li>
                <li>导出Excel时屏蔽公式，防止CSV注入风险</li>
                <li>组件ImageUpload支持多图同时选择上传</li>
                <li>组件FileUpload支持多文件同时选择上传</li>
                <li>代码生成树表新增(展开/折叠)</li>
                <li>代码生成子表支持日期/字典配置</li>
                <li>代码生成编辑修改打开新页签</li>
                <li>添加页签openPage支持传递参数</li>
                <li>添加清理分页的线程变量方法</li>
                <li>修改npm即将过期的注册源地址</li>
                <li>用户缓存信息添加部门ancestors祖级列表</li>
                <li>升级spring-cloud到最新版2021.0.1</li>
                <li>升级spring-boot到最新版本2.6.6</li>
                <li>升级spring-boot-admin到最新版2.6.6</li>
                <li>升级spring-boot-mybatis到最新版2.2.2</li>
                <li>降级jsencrypt版本兼容IE浏览器</li>
                <li>修复分页组件请求两次问题</li>
                <li>修复表单清除元素位置未垂直居中问题</li>
                <li>修复Excel注解prompt/combo同时使用不生效问题</li>
                <li>修复导入Excel时字典字段类型为Long转义为空问题</li>
                <li>修复登录超时刷新页面跳转登录页面还提示重新登录问题</li>
                <li>修复Xss注解字段值为空时的异常问题</li>
                <li>优化IP地址获取到多个的问题</li>
                <li>优化文件上传兼容Weblogic环境</li>
                <li>代码生成同步保留必填/类型选项</li>
                <li>优化Excel格式化不同类型的日期对象</li>
                <li>优化菜单表关键字导致的插件报错问题</li>
                <li>优化Oracle用户头像列为空时不显示问题</li>
                <li>优化页面若未匹配到字典标签则返回原字典值</li>
                <li>优化修复登录失效后多次请求提示多次弹窗问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.4.0 - 2022-01-24">
              <ol>
                <li>新增Vue3前端代码生成模板</li>
                <li>新增图片预览组件</li>
                <li>新增压缩插件实现打包Gzip</li>
                <li>新增docker一键复制的脚本</li>
                <li>自定义xss校验注解实现</li>
                <li>路由支持单独配置菜单或角色权限</li>
                <li>前端支持设置是否需要防止数据重复提交</li>
                <li>预览组件支持多图显示</li>
                <li>代码生成列表图片支持预览</li>
                <li>代码生成新增Java类型Boolean</li>
                <li>定时任务目标字符串过滤特殊字符</li>
                <li>定时任务目标字符串验证包名白名单</li>
                <li>升级nacos到最新版2.0.4</li>
                <li>升级spring-cloud到最新版2021.0.0</li>
                <li>升级spring-boot到最新版本2.6.3</li>
                <li>升级spring-boot-admin到最新版2.6.1</li>
                <li>升级pagehelper到最新版1.4.1</li>
                <li>升级fastjson到最新版1.2.79</li>
                <li>SQL工具类新增检查关键字方法</li>
                <li>修复打包后字体图标偶现的乱码问题</li>
                <li>修复版本差异导致的懒加载报错问题</li>
                <li>修复选项卡点击右键刷新丢失参数问题</li>
                <li>修复登录失效后多次请求提示多次弹窗问题</li>
                <li>优化加载字典缓存数据</li>
                <li>优化代码生成同步更新字段</li>
                <li>优化代码生成字典组重复问题</li>
                <li>优化空值不进行回显数据字典</li>
                <li>优化用户导入提示溢出则显示滚动条</li>
                <li>优化定时任务cron表达式小时设置24</li>
                <li>优化部门修改缩放后出现的错位问题</li>
                <li>优化分页方法设置成通用方便灵活调用</li>
                <li>优化用户管理部门查询选择节点后分页参数初始</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.3.0 - 2021-12-13">
              <ol>
                <li>新增配套并同步的Vue3前端版本</li>
                <li>新增认证对象简化权限验证</li>
                <li>新增tab对象简化页签操作</li>
                <li>修改获取缓存信息方式</li>
                <li>修改权限认证注解实现</li>
                <li>自定义文字复制剪贴指令</li>
                <li>升级axios到最新版本0.24.0</li>
                <li>升级core-js到最新版本3.19.1</li>
                <li>升级jsencrypt到最新版本3.2.1</li>
                <li>升级js-cookie到最新版本3.0.1</li>
                <li>升级clipboard到最新版本2.0.8</li>
                <li>升级velocity到最新版本2.3</li>
                <li>升级spring-boot到最新版本2.5.6</li>
                <li>升级spring-boot-admin到最新版2.5.4</li>
                <li>升级dynamic-ds到最新版本3.5.0</li>
                <li>代码生成预览支持复制内容</li>
                <li>修复五级以上菜单出现的404问题</li>
                <li>生产环境使用路由懒加载提升页面响应速度</li>
                <li>任务屏蔽违规字符&参数忽略双引号中的逗号</li>
                <li>优化用户个人信息接口防止修改用户名</li>
                <li>优化登录/验证码请求headers不设置token</li>
                <li>优化注册成功提示消息类型success</li>
                <li>优化下载解析blob响应是否登录失效</li>
                <li>修复字符串无法被反转义问题</li>
                <li>修复响应体过大出现的乱码问题</li>
                <li>修复回显数据字典组的键值错误</li>
                <li>修复代码生成复选框字典遗漏问题</li>
                <li>修复代码生成模板主子表删除缺少事务</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.2.0 - 2021-10-12">
              <ol>
                <li>菜单管理支持配置路由参数</li>
                <li>定时任务支持在线生成cron表达式</li>
                <li>自定义弹层溢出滚动样式</li>
                <li>自定义可拖动弹窗宽度指令</li>
                <li>自定义可拖动弹窗高度指令</li>
                <li>修改时检查用户数据权限范围</li>
                <li>修复保存配置主题颜色失效问题</li>
                <li>新增暗色菜单风格主题</li>
                <li>菜单&部门新增展开/折叠功能</li>
                <li>页签新增关闭左侧&添加图标</li>
                <li>代码生成主子表多选行数据</li>
                <li>日期范围支持添加多组</li>
                <li>Excel导入支持@Excels注解</li>
                <li>Excel注解支持导入导出标题信息</li>
                <li>Excel注解支持自定义数据处理器</li>
                <li>日志注解新增是否保存响应参数</li>
                <li>定时任务对检查异常进行事务回滚</li>
                <li>补充定时任务表字段注释</li>
                <li>定时任务屏蔽ldap远程调用</li>
                <li>新增通用方法简化下载使用</li>
                <li>新增通用方法简化模态/缓存使用</li>
                <li>新增data-dict组件简化数据字典使用</li>
                <li>禁用dict-tag组件的渐变动画</li>
                <li>默认首页使用keep-alive缓存</li>
                <li>升级springcloud到最新版2020.0.4</li>
                <li>升级spring-boot到最新版本2.5.5</li>
                <li>升级spring-boot-admin到最新版2.5.2</li>
                <li>升级pagehelper到最新版1.4.0</li>
                <li>升级fastjson到最新版1.2.78</li>
                <li>升级druid到最新版1.2.8</li>
                <li>升级element-ui到最新版本2.15.6</li>
                <li>升级sass-loader到最新版本10.1.1</li>
                <li>升级dart-sass到版本1.32.13</li>
                <li>升级file-saver到最新版本2.0.5</li>
                <li>优化异常处理信息</li>
                <li>验证码默认20s超时</li>
                <li>优化代码生成导入表按创建时间排序</li>
                <li>优化代码生成点击预览重置激活tab</li>
                <li>修复主子表代码模板方法名错误问题</li>
                <li>修复xss过滤后格式出现的异常</li>
                <li>修复多图组件验证失败被删除问题</li>
                <li>请求参数新增reasonable分页合理化属性</li>
                <li>修复代码生成页面数据编辑保存之后总是跳转第一页的问题</li>
                <li>修复带safari浏览器无法格式化utc日期格式yyyy-MM-dd'T'HH:mm:ss.SSS问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.1.0 - 2021-08-02">
              <ol>
                <li>支持配置XSS跨站脚本过滤</li>
                <li>支持配置验证码开关&类型</li>
                <li>新增是否开启用户注册功能</li>
                <li>用户管理新增分配角色功能</li>
                <li>角色管理新增分配用户功能</li>
                <li>系统布局配置支持动态标题开关</li>
                <li>增加字典标签样式回显dict组件</li>
                <li>FileUpload组件支持多文件上传</li>
                <li>ImageUpload组件支持多图片上传</li>
                <li>封装通用iframe组件</li>
                <li>菜单路由配置支持内链访问</li>
                <li>全局注册通用组件</li>
                <li>富文本默认上传返回url类型</li>
                <li>富文本新增上传文件大小限制</li>
                <li>增加自定义弹窗拖拽指令</li>
                <li>顶部菜单排除隐藏的默认路由</li>
                <li>跳转路由高亮相对应的菜单栏</li>
                <li>日志列表支持排序操作</li>
                <li>分页组件新增pagerCount属性</li>
                <li>定时任务屏蔽http(s)远程调用</li>
                <li>文件服务本地资源允许跨域访问</li>
                <li>升级spring-boot到最新版本2.5.3</li>
                <li>升级spring-boot-admin到最新版2.4.3</li>
                <li>升级spring-boot-mybatis到最新版2.2.0</li>
                <li>升级nacos到最新版2.0.3</li>
                <li>升级pagehelper到最新版1.3.1</li>
                <li>升级minio到最新版本8.2.2</li>
                <li>升级tobato到最新版本1.27.2</li>
                <li>升级dynamic-ds到最新版本3.4.1</li>
                <li>升级commons.io到最新版本v2.11.0</li>
                <li>升级common-pool到最新版本2.10.0</li>
                <li>升级commons.fileupload到最新版本v1.4</li>
                <li>升级element-ui到最新版本2.15.3</li>
                <li>优化统一网关错误码响应</li>
                <li>修复导出含params属性对象参数问题</li>
                <li>修复任意账户越权问题</li>
                <li>修复定时任务日志执行状态显示</li>
                <li>修改登录失效返回值code401</li>
                <li>用户信息长度校验限制</li>
                <li>角色&菜单新增字段属性提示信息</li>
                <li>修复用户搜索分页变量错误</li>
                <li>优化部门父级启用状态</li>
                <li>启用部门状态排除顶级节点</li>
                <li>定时任务新增更多操作</li>
                <li>优化代码生成模板</li>
                <li>优化顶部菜单显示样式</li>
                <li>优化导入用户显示样式</li>
                <li>优化用户不能删除自己</li>
                <li>密码框新增显示切换密码图标</li>
                <li>BLOB下载时清除URL对象引用</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.0.0 - 2021-06-10">
              <ol>
                <li>新增菜单导航显示风格TopNav（false为左侧导航菜单，true为顶部导航菜单）</li>
                <li>布局设置支持保存&重置配置</li>
                <li>富文本编辑器支持自定义上传地址</li>
                <li>富文本编辑组件新增readOnly属性</li>
                <li>优化参数&字典缓存操作</li>
                <li>新增IE浏览器版本过低提示页面</li>
                <li>页签TagsView新增关闭右侧功能</li>
                <li>显隐列组件加载初始默认隐藏列</li>
                <li>关闭头像上传窗口还原默认图片</li>
                <li>个人信息添加手机&邮箱重复验证</li>
                <li>代码生成模板树表操作列添加新增按钮</li>
                <li>代码生成模板修复主子表字段重名问题</li>
                <li>支持docker部署项目</li>
                <li>升级springcloud到最新版2020.0.3</li>
                <li>升级spring-boot-alibaba到最新版2021.1</li>
                <li>升级nacos到最新版2.0.1 性能提升</li>
                <li>升级spring-boot到最新版本2.5.0</li>
                <li>升级spring-boot-admin到最新版2.4.1</li>
                <li>升级swagger到最新版本3.0.0</li>
                <li>升级mybatis到最新版3.5.6</li>
                <li>升级dynamic-ds到最新版本3.3.2</li>
                <li>升级minio到最新版本8.2.1</li>
                <li>升级fastjson到最新版1.2.76</li>
                <li>升级druid到最新版本v1.2.6</li>
                <li>修复四级菜单无法显示问题</li>
                <li>修复树表数据显示不全&加载慢问题</li>
                <li>修复关闭confirm提示框控制台报错问题</li>
                <li>上传媒体类型添加视频格式</li>
                <li>增加feign客户端IP头部信息</li>
                <li>修复两处存在SQL注入漏洞问题</li>
                <li>优化图片工具类读取文件，防止异常</li>
                <li>修复导出角色数据范围翻译缺少仅本人</li>
                <li>修复表单构建选择下拉选择控制台报错问题</li>
                <li>修复请求形参未传值记录日志异常问题</li>
                <li>调整sql默认为当前时间</li>
                <li>修改ip字段长度防止ipv6地址长度不够</li>
                <li>删除操作日志记录信息</li>
                <li>修复firefox下表单构建拖拽会新打卡一个选项卡</li>
                <li>用户&角色单条删除时使其逻辑删除</li>
                <li>优化树表代码生成模板</li>
                <li>修正通知公告日志记录类型</li>
                <li>修正后端导入表权限标识</li>
                <li>过滤BindingResult对象，防止异常</li>
                <li>Redis设置HashKey序列化</li>
                <li>优化Excel导入增加空行判断</li>
                <li>树级结构更新子节点使用replaceFirst</li>
                <li>富文本工具栏配置视频</li>
                <li>修正模板字符编码</li>
                <li>优化通用下载完成后删除节点</li>
                <li>角色非自定义权限范围清空选择值</li>
                <li>修改主题后mini类型按钮无效问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.5.0 - 2021-02-02">
              <ol>
                <li>增加分布式事务seata支持</li>
                <li>代码生成模板支持主子表</li>
                <li>表格右侧工具栏组件支持显隐列</li>
                <li>图片组件添加预览&移除功能</li>
                <li>Excel注解支持Image图片导出</li>
                <li>操作按钮组调整为朴素按钮样式</li>
                <li>代码生成支持文件上传组件</li>
                <li>代码生成日期控件区分范围</li>
                <li>代码生成数据库文本类型生成表单文本域</li>
                <li>用户手机邮箱&菜单组件修改允许空字符串</li>
                <li>修复header获取username中文情况下乱码</li>
                <li>修复角色管理-编辑角色-功能权限显示异常</li>
                <li>修正操作日志删除接口路径</li>
                <li>修复IE11浏览器报错问题</li>
                <li>修复sentinel流量告警前端不响应</li>
                <li>修正侧边栏静态路由丢失问题</li>
                <li>修复导入数据为负浮点数时丢失精度问题</li>
                <li>修复Get请求参数特殊值无法正确的传参</li>
                <li>更换过期的共享配置属性</li>
                <li>添加启动执行脚本</li>
                <li>升级element-ui到最新版本2.15.0</li>
                <li>升级spring-boot到最新版本2.3.7</li>
                <li>升级spring-cloud到Hoxton.SR9</li>
                <li>升级spring-boot-alibaba到最新版2.2.5</li>
                <li>升级spring-boot-admin到最新版2.3.1</li>
                <li>升级druid到最新版本v1.2.4</li>
                <li>升级fastjson到最新版1.2.75</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.4.0 - 2020-12-22">
              <ol>
                <li>增加分布式文件Minio支持</li>
                <li>支持多数据源切换</li>
                <li>修复多级菜单之间切换无法缓存的问题</li>
                <li>三级菜单自动配置组件</li>
                <li>支持主题风格配置</li>
                <li>服务之间feign调用传递用户信息</li>
                <li>删除用户和角色解绑关联</li>
                <li>去除用户手机邮箱部门必填验证</li>
                <li>代码生成预览支持高亮显示</li>
                <li>获取请求token方法移至权限工具类</li>
                <li>代码生成预览提供滚动机制</li>
                <li>权限工具类增加管理员判断</li>
                <li>日志记录增加过滤多文件场景</li>
                <li>修改用户头像预览宽高</li>
                <li>Excel支持注解align对齐方式</li>
                <li>项目添加robots.txt 防止系统被搜索引擎收录</li>
                <li>移除path-to-regexp正则匹配插件</li>
                <li>修改Set可能导致嵌套的问题</li>
                <li>调整代码生成页列宽</li>
                <li>回显数据字典防止空值报错</li>
                <li>支持get请求映射params参数</li>
                <li>登录后push添加catch防止出现检查错误</li>
                <li>防止安全扫描YUI出现的风险提示</li>
                <li>代码生成删除多余的数字float类型</li>
                <li>Excel支持导入Boolean型数据</li>
                <li>修正转换字符串的目标字符集属性</li>
                <li>删除多余的依赖</li>
                <li>修改node-sass为dart-sass</li>
                <li>升级poi到最新版本4.1.2</li>
                <li>升级axios到最新版本0.21.0</li>
                <li>升级element-ui到最新版本2.14.1</li>
                <li>升级vue到最新版本2.6.12</li>
                <li>升级vuex到最新版本3.6.0</li>
                <li>升级vue-cli到版本4.5.9</li>
                <li>升级vue-router到最新版本3.4.9</li>
                <li>升级vue-cli到最新版本4.4.6</li>
                <li>升级vue-cropper到最新版本0.5.5</li>
                <li>升级clipboard到最新版本2.0.6</li>
                <li>升级core-js到最新版本3.8.1</li>
                <li>升级echarts到最新版本4.9.0</li>
                <li>升级file-saver到最新版本2.0.4</li>
                <li>升级fuse.js到最新版本6.4.3</li>
                <li>升级js-beautify到最新版本1.13.0</li>
                <li>升级js-cookie到最新版本2.2.1</li>
                <li>升级path-to-regexp到最新版本6.2.0</li>
                <li>升级quill到最新版本1.3.7</li>
                <li>升级screenfull到最新版本5.0.2</li>
                <li>升级sortablejs到最新版本1.10.2</li>
                <li>升级vuedraggable到最新版本2.24.3</li>
                <li>升级chalk到最新版本4.1.0</li>
                <li>升级eslint到最新版本7.15.0</li>
                <li>升级eslint-plugin-vue到最新版本7.2.0</li>
                <li>升级lint-staged到最新版本10.5.3</li>
                <li>升级runjs到最新版本4.4.2</li>
                <li>升级sass-loader到最新版本10.1.0</li>
                <li>升级script-ext-html-webpack-plugin到最新版本2.1.5</li>
                <li>升级svg-sprite-loader到最新版本5.1.1</li>
                <li>升级vue-template-compiler到最新版本2.6.12</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.3.0 - 2020-11-20">
              <ol>
                <li>新增文件服务应用（支持本地、FastDFS）</li>
                <li>优化头像样式，鼠标移入悬停遮罩</li>
                <li>AjaxResult重写put方法，以方便链式调用</li>
                <li>代码生成支持上传控件</li>
                <li>新增图片上传组件</li>
                <li>支持用户头像更新</li>
                <li>调整默认首页</li>
                <li>角色权限验证hasRole匹配改为equals</li>
                <li>修正数组权限为空判断</li>
                <li>修正注释选中节点和半选节点获取</li>
                <li>升级pagehelper到最新版1.3.0</li>
                <li>升级fastjson到最新版1.2.74</li>
                <li>修正定时任务执行一次权限标识</li>
                <li>修复页签关闭所有固定标签路由不刷新问题</li>
                <li>表单构建布局型组件新增按钮</li>
                <li>调整日志路径到模块目录</li>
                <li>修正菜单提示信息错误</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.2.0 - 2020-10-10">
              <ol>
                <li>移除 OAuth2 改为 Redis</li>
                <li>升级SpringCloud到最新版本Hoxton.SR8</li>
                <li>升级SpringCloud Alibaba到最新版本2.2.3</li>
                <li>升级SpringBoot Admin到最新版本2.3.0</li>
                <li>升级Fastjson到最新版1.2.73</li>
                <li>新增在线用户会话管理</li>
                <li>修改用户个人资料/密码同步缓存信息</li>
                <li>修复前端通用导出方法参数传值请求方式问题</li>
                <li>菜单新增是否缓存keep-alive</li>
                <li>菜单&数据权限新增（展开/折叠 全选/全不选 父子联动）</li>
                <li>Job与Gen模块增加Redis默认配置</li>
                <li>新增表格右侧工具栏组件right-toolbar</li>
                <li>代码生成支持同步数据库</li>
                <li>代码生成支持富文本控件</li>
                <li>代码生成树模板去掉多余双引号</li>
                <li>代码生成添加select必填选项</li>
                <li>代码生成页面时不忽略remark属性</li>
                <li>修复代码生成下载路径错误</li>
                <li>左侧菜单文字过长显示省略号</li>
                <li>表格操作列间距调整</li>
                <li>Excel注解支持自动统计数据总和</li>
                <li>Excel注解支持设置BigDecimal精度&舍入规则</li>
                <li>导入Excel整形值校验优化</li>
                <li>导出Excel类型NUMERIC支持精度浮点类型</li>
                <li>导出Excel调整targetAttr获取值方法，防止get方法不规范</li>
                <li>Token续期调整为后端刷新</li>
                <li>Token设置默认有效期时长12小时</li>
                <li>网关白名单放入nacos配置&支持模糊匹配</li>
                <li>修复富文本工具栏样式不对齐问题</li>
                <li>Editor组件优化，支持自定义高度&图片冲突问题</li>
                <li>
                  修复富文本空格和缩进保存后不生效问题&删除重复的placeholder
                </li>
                <li>限制系统内置参数不允许删除</li>
                <li>修正调用目标字符串最大长度</li>
                <li>修改自定义权限实现</li>
                <li>优化递归菜单&部门子节点</li>
                <li>修改sass为node-sass，避免el-icon图标乱码</li>
                <li>修复根节点为子部门时，树状结构显示问题</li>
                <li>全局异常状态汉化拦截处理</li>
                <li>唯一限制条件只返回单条数据</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v2.1.0 - 2020-08-02">
              <ol>
                <li>表格工具栏右侧添加刷新&显隐查询栏</li>
                <li>OAuth自动刷新续签Token</li>
                <li>网关支持黑名单配置</li>
                <li>权限配置自动注册</li>
                <li>Feign配置自动注册</li>
                <li>代码生成支持选择上级菜单</li>
                <li>代码生成支持复选框</li>
                <li>代码生成支持自定义路径</li>
                <li>验证码类型支持（数组计算、字符验证）</li>
                <li>Excel支持sort导出排序</li>
                <li>Excel支持分割字符串组内容</li>
                <li>excel 导入数字不需要格式化 ，导入允许列和属性个数不一致</li>
                <li>新增菜单默认主类目</li>
                <li>升级vue-cli版本到4.4.4</li>
                <li>修改 node-sass 为 dart-sass</li>
                <li>升级element-ui版本到2.13.2</li>
                <li>删除babel，提高编译速度</li>
                <li>修复验证码异常时network面板的中文会出现乱码问题</li>
                <li>修复 utils/index.js 中不包含 parseTime 函数的 bug</li>
                <li>优化selectDictLabel方法，数组迭代器换为some</li>
                <li>修复客户端模式认证会出现错误</li>
                <li>检查字符支持小数点&降级改成异常提醒</li>
                <li>定时任务添加cron表达式验证</li>
                <li>代码生成查询条件修正</li>
                <li>修正角色管理导出权限权限字符</li>
                <li>修正防止切换权限用户后登录出现404</li>
                <li>终端设置安全码加密&更新缓存</li>
                <li>修复头像上传成功二次打开无法改变裁剪框大小和位置问题</li>
                <li>修复布局为small者mini用户表单显示错位问题</li>
                <li>修复代码生成点击多次表修改数据不变化的问题</li>
                <li>修复代码生成导入表结构出现异常页面不提醒问题</li>
                <li>修复角色权限修改时已有权限未自动勾选异常</li>
                <li>创建用户不允许选择系统管理员角色</li>
                <li>添加全局异常处理（网关异常&业务异常）</li>
                <li>修复终端查询Enter键搜索时是刷新页面而不是查询列表</li>
                <li>删除job重复表单参数</li>
                <li>代码生成浮点型改用BigDecimal</li>
                <li>表单类型为Integer/Long设置整形默认值</li>
                <li>修改用户管理复选框宽度，防止部分浏览器出现省略号</li>
                <li>
                  RedisCache中所有方法参数添加final，并优化list取出效率，添加其它常用redis方法
                </li>
                <li>修正定时任务日志权限字符</li>
                <li>添加Jackson时区配置</li>
                <li>代码生成相关问题修复</li>
                <li>自定义oauth2返回异常信息</li>
                <li>升级nacos到最新版1.3.0 全新内核构建</li>
                <li>修正【代码生成】功能无法下载的问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v2.0.0 - 2019-12-02">
              <ol>
                <li>新增代码生成</li>
                <li>新增@RepeatSubmit注解，防止重复提交</li>
                <li>新增菜单主目录添加/删除操作</li>
                <li>日志记录过滤特殊对象，防止转换异常</li>
                <li>修改代码生成路由脚本错误</li>
                <li>用户上传头像实时同步缓存，无需重新登录</li>
                <li>调整切换页签后不重新加载数据</li>
                <li>添加jsencrypt实现参数的前端加密</li>
                <li>系统退出删除用户缓存记录</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.0.0 - 2020-06-10">
              <ol>
                <li>使用Sentinel代替Hystrix</li>
                <li>菜单新增终端管理配置</li>
                <li>菜单新增Nacos&Sentinel控制台</li>
                <li>代码生成适配Cloud</li>
                <li>记录登录退出日志信息</li>
                <li>网关验证码过滤器添加放行校验</li>
                <li>个性化的定制自动加载类</li>
                <li>定时任务调整label-width，防止部署出现错位</li>
                <li>调整表头固定列默认样式</li>
                <li>代码生成模板调整，字段为String并且必填则加空串条件</li>
                <li>代码生成字典Integer/Long使用parseInt</li>
                <li>修复退出登录重定向到登录页，登录后参数丢失。</li>
                <li>修正岗位导出权限注解</li>
                <li>修复首页搜索菜单外链无法点击跳转问题</li>
                <li>修复菜单管理选择图标，backspace删除时不过滤数据</li>
                <li>用户管理部门分支节点不可检查&显示计数</li>
                <li>数据范围过滤属性调整</li>
                <li>字典管理添加缓存读取</li>
                <li>参数管理支持缓存操作</li>
                <li>升级fastjson到最新版1.2.70 修复高危安全漏洞</li>
                <li>dev启动默认打开浏览器</li>
                <li>使用vue-cli默认source-map</li>
                <li>slidebar eslint报错优化</li>
                <li>当tags-view滚动关闭右键菜单</li>
                <li>支持一级菜单（和主页同级）在main区域显示</li>
                <li>限制外链地址必须以http(s)😕/开头</li>
                <li>tagview & sidebar 主题颜色与element ui(全局)同步</li>
                <li>
                  修复dict_sort不可update为0的问题&查询返回增加dict_sort升序排序
                </li>
                <li>权限部分代码调整</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.0 - 2020-05-20">
              <ol>
                <li>若依微服务系统正式发布</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>捐赠支持</span>
          </div>
          <div class="body">
            <img
              src="@/assets/images/pay.png"
              alt="donate"
              width="100%"
            />
            <span style="display: inline-block; height: 30px; line-height: 30px"
              >你可以请作者喝杯咖啡表示鼓励</span
            >
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.6.3",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

