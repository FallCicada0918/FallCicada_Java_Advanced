<!--
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-11-25 08:41:50
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-11-29 08:38:14
 * @: 無限進步
-->
# Mybatis
在前面我们学习MySQL数据库时，要么利用图形化客户端工具(如：idea、datagrip)，来操作数据库，要么使用在Java代码中使用JDBC操作数据库。

>在客户端工具中，编写增删改查的SQL语句，发给MySQL数据库管理系统，由数据库管理系统执行SQL语句并返回执行结果。
>
>增删改操作：返回受影响行数
>
>查询操作：返回结果集(查询的结果)

我们做为后端程序开发人员，实际项目开发中通常会使用Mybatis来操作数据
库。

什么是MyBatis?

- MyBatis是一款优秀的 **持久层 框架**，用于简化JDBC的开发。
- MyBatis本是 Apache的一个开源项目iBatis，2010年这个项目由apache迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github。
- 官网：https://mybatis.org/mybatis-3/zh/index.html 

在上面我们提到了两个词：一个是持久层，另一个是框架。

- 持久层：指的是就是数据访问层(dao)，是用来操作数据库的。

![](./images/image.png)

- 框架：是一个半成品软件，是一套可重用的、通用的、软件基础代码模型。在框架的基础上进行软件开发更加高效、规范、通用、可拓展。

|||||
|:-----------:|:---------:|:-----:|:-------:|
|controller ->|表现层|处理用户请求和相应数据||
|service ->   |业务层|处理业务逻辑         ||
|dao ->       |持久层|操作数据库       ||
|mapperer ->  |数据库|           ||

# 入门
Mybatis操作数据库的步骤：
1. 准备工作(创建springboot工程、数据库表t_user、实体类User)
2. 引入Mybatis的相关依赖，配置Mybatis(数据库连接信息)
3. 编写SQL语句

在正式创建SpringBoot项目之前，我们先大致了解下SpringBoot及项目结构。

## SpringBoot 
是由Pivotal团队提供的全新框架，其设计目的是用来简化Spring应用的初始搭建以及开发过程。
**Spring创建方式**：
1. idea直接创建
   - 一部分低版本JDK不支持直接创建 
2. 从官方网站创建下载项目
   -  [Spring官网](https://start.spring.io/)
3. 方式3：
    - [阿里巴巴脚手架](https://start.aliyun.com/)
    ```  
      项目构建方式 maven
      开发语言 java
      SpringBoot版本 2.7.6
      项目基本信息 
        com.briup
        demo 
      高级选项
        Java版本 8
      组件与示例
        MyBatis Framework
        MySQL Driver 
        Lombok
          Lombok是一个实用的Java类库，可以通过简单的注解来简化和消除一些必须有但显得很臃肿的Java代码。
          提高开发效率
    ```
**Spring程序缺点**：
- 配置繁琐
- 依赖设置繁琐
**SpringBoot程序优点**：
- 自动配置
- 起步依赖（简化依赖配置）
- 辅助功能（内置服务器等）
**SpringBoot项目结构**：

## 项目实例
在briup数据库中创建t_user表 插入数据
- 用户表
  ```SQL
  create table t_user(
  id int unsigned primary key auto_increment comment 'ID',
  name varchar(100) comment '姓名',
  age tinyint unsigned comment '年龄',
  gender tinyint unsigned comment '性别, 1:男, 2:女',
  phone varchar(11) comment '手机号'
  ) comment '用户表';
  ```
- 测试数据
```SQL
  insert into t_user(id, name, age, gender, phone) VALUES(null,'白眉鹰王',55,'1','18800000000');
  insert into t_user(id, name, age, gender, phone) VALUES(null,'金毛狮王',45,'1','18800000001');
  insert into t_user(id, name, age, gender, phone) VALUES(null,'青翼蝠王',38,'1','18800000002');
  insert into t_user(id, name, age, gender, phone) VALUES(null,'紫衫龙王',42,'2','18800000003');
  insert into t_user(id, name, age, gender, phone) VALUES(null,'光明左使',37,'1','18800000004');
  insert into t_user(id, name, age, gender, phone) VALUES(null,'光明右使',48,'1','18800000005');
```
- 在项目文件夹demo中创建实体类User 加注解以省略get、set方法
- 修改配置文件 application.properties
```properties
  #配置数据库相关的内容
  #驱动类名称
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  #数据库连接的url
  spring.datasource.url=jdbc:mysql://localhost:3306/briup
  #连接数据库的用户名
  spring.datasource.username=briup
  #连接数据库的密码
  spring.datasource.password=briup
```
- 写sql语句
  - 创建一个包 mapper 在mapper下创建一个 UserMapper 这是一个持久层的接口
  - MyBatis的持久层一般都叫xxxMapper
- 单元测试
  - 测试类已经创建好了

- 连接池
  - 默认使用：追光者 hikari 
  - 德鲁伊 阿里巴巴旗下开源项目 Druid
  - 切换连接池
- 日志显示
  - 配置文件 
``` 
    application.properties 
    #指定mybatis输出日志的位置, 输出控制台
    mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

### 数据封装

  MyBatis中 如果实体类属性和数据库表中查询返回的字段名相同（完全一致）那么MyBatis会自动封装
  如果不一致，MyBatis不能自动封装
  解决方案：
    1. 起别名 register_time as registerTime 
    2. 开启驼峰命名 ，MyBatis会自动通过驼峰命名规则来映射
    在配置文件application.properties中
    #开启驼峰命名
    mybatis.configuration.map-underscore-to-camel-case=true
    一定要注意命名规范
    3. 手动结果映射
      @Results({@Result(column="register_time",property="registerTime")})

MyBatis开发方式
1. 注解 
  主要完成简单的增删改查功能，如果有比较复杂的sql建议使用XML配置映射语句，也就是把sql语句写到XML配置文件中
2. XML
  1. XML映射文件的名称与Mapper接口名一致，且XML映射文件和Mapper接口放置在相同包下面（同包同名）
  2. XML映射文件的namespace属性和Mapper接口的全限定名一致
  3. XML映射文件中的sql语句的id与mapper接口中方法名法一致，并且返回类型一致


1. 创建项目
2. 创建XML映射文件UserMapper.xml



maven下载有问题解决方式
  1. 换个网络
  2. 换个maven（idea自带的换成自己安装的）
  3. 更改maven下载依赖的源地址，改为国内镜像
    全局修改位置在：setting.xml文件
    类似于：npm cnpm 国内镜像
    百度：maven仓库更改源地址
      <mirror>
        <id>alimaven</id>
        <mirrorOf>central</mirrorOf>  
        <name>aliyun maven</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public/</url>      
      </mirror>
  4. 直接把别人的本地仓库搬过来 
    注意软件版本相同 jdk maven SpringBoot idea 
  5. 注意其他任意技术栈出现类似的问题都是类似的解决方案比如vue-project

Maven仓库和NodeModules仓库的对比
    Maven仓库是本地仓库，一般情况下一台计算机只有一个Maven仓库
    NodeModules仓库是基于项目的，每个项目文件夹都有一个单独的NodeModules仓库

#### if
  用于判断条件是否成立 如果成立则拼接标签中的sql语句
    <if test="条件语句">
      SQL语句
    </if>
  
#### where
  在子元素有内容的情况下插入where子句，并且会自动去除子句中的and、or

#### set
  动态的在行首添加set关键字 并且会删除多余的逗号


数据库密码加密MD5

### 配置文件类型
springboot项目自带的 application.properties
  
yml格式的

**后缀名** 
- .yml
- .yaml
    
    xml


1. 两种配置文件有啥区别？
  
2. 旧的配置文件本身就有问题 
    
    2.1. mapper写的有问题 本身代码就报错
3. 配置文件的位置 和原来的配置文件位置一样
4. 没有启动数据库
5. 数据库用户名密码错误

### yml文件的格式
- 大小写敏感 
- key: value 
- value前面必须有空格作为分隔符
- 使用缩进表示层级关系，缩进要使用空格
- 缩进的空格数不重要，重要的是每一级的缩进对齐
- #是单行注释
#### 配置文件的优先级
1. .properties
2. .yml 
3. .yaml

在 `<select>` 语句中，这里使用的是resultMap属性，而不是resultType属性

resultType 和 resultMap 是不能同时存在的

resultMap 中可以实现继承


