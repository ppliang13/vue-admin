# 实体类的分类
## 1. POJO 最上级 model（模块的名称）
POJO（Plain Ordinary Java Object）：在本手册中，POJO专指只有 setter/getter/toString 的简单类，包括 DO/DTO/BO/VO 等。

DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO层向上传输数据源对象。
DTO（Data Transfer Object）：数据传输对象，Service 或Manager 向外传输的对象。
BO（Business Object）：业务对象，可以由Service层输出的封装业务逻辑的对象。
REQ：数据查询对象，各层接收上层的查询请求。注意超过2 个参数的查询封装，禁止使用 Map 类 来传输。
VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。

## 2. 对像之间的拷贝
使用hutool工具类中的BeanUtil.copyProperties()方法进行对象之间的拷贝，注意拷贝的对象中的属性名称要一致，否则拷贝不成功。
```xml
    <dependency>
      <groupId>cn.hutool</groupId>
      <artifactId>hutool-all</artifactId>
    </dependency>
```
使用方法：
```java
    BeanUtil.copyProperties(user, userVO);
```