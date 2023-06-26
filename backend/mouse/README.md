# MOUSE 微服务项目

## 项目介绍
项目的主要目的是实现一个微服务项目模块，用于快速构建项目，开发项目。
主要使用的技术：


项目结构介绍：
- mouse-base：基础jar包，用于提供项目的基础功能。
  - mouse-base-api：基础api模块，包含一些基础的工具类，基础的配置类，基础的异常类，基础的实体类等。
  - mouse-base-common：基础的公共模块，基础实体类。
  - mouse-base-utils：基础的工具类模块。

- mouse-model：应用模块
  - mouse-demo：案例模块
  
- mouse-service：服务模块
  - mouse-postgresql：postgresql数据库服务模块
  - mouse-redis：redis服务模块
  - mouse-rocketmq：rocketmq服务模块
  - mouse-rabbitmq：rabbitmq服务模块
  - mouse-kafka：kafka服务模块
  - mouse-elasticsearch：elasticsearch服务模块

- mouse-auth：认证模块
  - mouse-auth-server：认证服务模块
  - mouse-auth-client：认证客户端模块