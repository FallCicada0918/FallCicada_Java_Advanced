<!--
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-11-18 15:26:38
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-11-20 19:44:26
 * @: 無限進步
-->
# JDBC(Java DataBase Connectivity)
## 引入
java数据库连接 技术

是一种技术规范 制定了一套程序连接数据库的api 去访问不同的数据库

Sun公司定义了一套操作所有关系型数据库的规则

各个数据库厂商去提供驱动包jar
## idea创建项目
  - Java 
  - jdk1.8
  - 下一步不需要选择默认模版 直接下一步

### lib目录
  library 用于存放第三方库和依赖包
### junit   
  单元测试
### mysql-connector-java-8.0.28
  jdbc-mysql驱动

## executeUpdate 执行结果
  + 如果执行的语句是DDL语句（数据定义语言(Data Definition Language)）那么返回值是0
  + 如果执行的是DML语句（数据操作语言(Data Manipulation Language)）那么返回值是修改的行数
  + 如果执行的是DQL语句（数据查询语言(Data Query Language)）返回值是一个对象或者null
### DML语句（数据操作语言(Data Manipulation Language)）insert update delete 


## DQL语句（数据查询语言(Data Query Language)）
  + select 返回值是一个对象或者null
  + ResultSet 对象 封装了sql查询语句的结果 使用结束也需要关闭资源
  + rs = stmt.executeQuery(sql); // 注意这里执行的是查询语句 不是Update了

## sql注入攻击
  + 在应用程序没有正确验证和处理用户输入的情况下，会出现这个漏洞
  + 利用用户输入的数据作为查询语句的一部分，绕过身份验证，窃取数据，修改数据。。执行任意命令
 
### 如何解决这个问题
  1. 严格限制用户名密码格式
  2. 修改代码结构防止漏洞出现比如count=3还能登录成功
  3. PreparedStatement 是 Statement的子接口，提供了更高效和安全的方式执行#### sql语句

- JDBC中写的sql语句不需要加分号
- mysql命令行中执行的需要加分号
## stmt.addBatch
自动提交事务
### 连接池 
  优化服务器应用程序性能，提高程序执行效率，降低系统资源开销

  在系统初始化时创建一定数量数据库连接对象，需要时直接从池中取出一个空闲对象，用完后并不直接释放掉对象，而是再放到对象池中，以便下一次对象请求可以直接复用。消除了对象创建和销毁所带来的延迟，从而提高系统的性能

#### 常见的数据库连接池
- DBCP
- C3P0
- Druid （德鲁伊）
>性能稍好 是阿里巴巴开源的数据库连接池项目
>
>功能强大 性能优秀
>
> druid-1.2.16.jar
##### 使用 
1. jar包导入
2. 添加配置文件 /src/druid.properties
3. 数据库连接四要素
```java
// 1. 驱动
String driver = "com.mysql.cj.jdbc.Driver";
// 2. 数据库地址
String url = "jdbc:mysql://127.0.0.1:3306/jdbc_test";
// 3. 用户名 - 写自己数据库的用户名
String username = "fallcicada";
// 4. 密码 - 写自己数据库的密码
String password = "9572";
```
4. 六大步
```java
try {
    // 1. 注册驱动
    Class.forName(driver);
    // 2. 获取连接对象
    conn = DriverManager.getConnection(url, username, password);
    // 输出连接对象
    System.out.println(conn);
    // 3. 获取数据库操作对象
    stmt = conn.createStatement();
    // 4. 执行sql
    String sql = "CREATE DATABASE IF NOT EXISTS jdbc_test";
    stmt.executeUpdate(sql);
    // 5. 处理查询结果
    int count = stmt.executeUpdate(sql);
    // 输出受影响的行数
    System.out.println(count);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    // 6. 释放资源
    try {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```





Hamcrest-core是一个用于编写匹配器对象的框架，主要用于测试驱动开发（TDD）和行为驱动开发（BDD）中，帮助开发者验证代码的行为是否符合预期‌。 