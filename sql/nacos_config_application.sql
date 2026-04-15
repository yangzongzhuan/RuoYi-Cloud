-- ============================================
-- Nacos 配置中心配置 - ruoyi-application 模块
-- 需要在 ry-config 数据库中执行
-- ============================================

USE `ry-config`;

-- 1. 添加 ruoyi-application-dev.yml 配置
-- 注意：请根据实际环境修改数据库连接、Redis密码等配置
INSERT INTO `config_info` (`data_id`, `group_id`, `content`, `md5`, `gmt_create`, `gmt_modified`, `src_user`, `src_ip`, `app_name`, `tenant_id`, `c_desc`, `c_use`, `effect`, `type`, `c_schema`, `encrypted_data_key`) 
VALUES (
    'ruoyi-application-dev.yml',
    'DEFAULT_GROUP',
    '# spring配置
spring:
  data:
    redis:
      host: 127.0.0.1
      port: 6379
      password: jingneng2023
  datasource:
    druid:
      stat-view-servlet:
        enabled: true
        loginUsername: ruoyi
        loginPassword: 123456
    dynamic:
      druid:
        initial-size: 5
        min-idle: 5
        maxActive: 20
        maxWait: 60000
        connectTimeout: 30000
        socketTimeout: 60000
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQuery: SELECT 1 FROM DUAL
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxPoolPreparedStatementPerConnectionSize: 20
        filters: stat,slf4j
        connectionProperties: druid.stat.mergeSql\=true;druid.stat.slowSqlMillis\=5000
      datasource:
          master:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
            username: root
            password: root

# mybatis配置
mybatis:
    typeAliasesPackage: com.ruoyi.application
    mapperLocations: classpath:mapper/**/*.xml

# springdoc配置
springdoc:
  gatewayUrl: http://localhost:8081/${spring.application.name}
  api-docs:
    enabled: true
  info:
    title: ''应用模块接口文档''
    description: ''应用模块接口描述''
    contact:
      name: RuoYi
      url: https://ruoyi.vip
',
    MD5('# spring配置\nspring:\n  data:\n    redis:\n      host: 127.0.0.1\n      port: 6379\n      password: jingneng2023\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: ruoyi\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        connectTimeout: 30000\n        socketTimeout: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n\n# mybatis配置\nmybatis:\n    typeAliasesPackage: com.ruoyi.application\n    mapperLocations: classpath:mapper/**/*.xml\n\n# springdoc配置\nspringdoc:\n  gatewayUrl: http://localhost:8081/${spring.application.name}\n  api-docs:\n    enabled: true\n  info:\n    title: ''应用模块接口文档''\n    description: ''应用模块接口描述''\n    contact:\n      name: RuoYi\n      url: https://ruoyi.vip\n'),
    NOW(),
    NOW(),
    'nacos',
    '127.0.0.1',
    '',
    '',
    '应用模块',
    'null',
    'null',
    'yaml',
    '',
    ''
);

-- 2. 更新 ruoyi-gateway-dev.yml 添加 customer 路由
-- 注意：这需要手动在 Nacos 控制台修改，或者执行以下更新
-- 以下是需要添加的路由配置片段：
/*
            # 应用模块
            - id: ruoyi-application
              uri: lb://ruoyi-application
              predicates:
                - Path=/customer/**
              filters:
                - StripPrefix=1
*/

-- 3. 更新 sentinel-ruoyi-gateway 添加 ruoyi-application 限流策略
UPDATE `config_info` 
SET `content` = REPLACE(`content`, 
    '    {\r\n        \"resource\": \"ruoyi-job\",\r\n        \"count\": 300,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    }\r\n]',
    '    {\r\n        \"resource\": \"ruoyi-job\",\r\n        \"count\": 300,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n\t{\r\n        \"resource\": \"ruoyi-application\",\r\n        \"count\": 500,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    }\r\n]'
)
WHERE `data_id` = 'sentinel-ruoyi-gateway';
