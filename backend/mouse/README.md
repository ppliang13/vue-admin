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
  - mouse-service-postgresql：postgresql数据库服务模块
  - mouse-service-redis：redis服务模块
  - mouse-service-rocketmq：rocketmq服务模块
  - mouse-service-rabbitmq：rabbitmq服务模块
  - mouse-service-kafka：kafka服务模块
  - mouse-service-elasticsearch：elasticsearch服务模块
  - mouse-service-springData：mongodb服务模块

- mouse-auth：认证模块
  - mouse-auth-server：认证服务模块
  - mouse-auth-client：认证客户端模块

分层领域模型规约:

DO(Data Object):此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
DTO(Data Transfer Object):数据传输对象，Service 或 Manager 向外传输的对象。
BO(Business Object):业务对象，由 Service 层输出的封装业务逻辑的对象。
AO(ApplicationObject):应用对象，在Web层与Service层之间抽象的复用对象模型， 极为贴近展示层，复用度不高。
VO(View Object):显示层对象，通常是 Web 向模板渲染引擎层传输的对象。
Query:数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类来传输。