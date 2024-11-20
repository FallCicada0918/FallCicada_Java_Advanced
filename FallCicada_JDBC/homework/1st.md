## 姓名：马荟荣

## 学号：2208300049

## JDBC作业

### 1.什么是JDBC？

#### 答：

JDBC(Java DataBase Connectivity)是一种技术规范，制定了一套程序连接数据库的API，用于访问不同的数据库。Sun公司定义了一套操作所有关系型数据库的规则，各个数据库厂商提供驱动包jar。

### 2.JDBC连接的步骤是什么？

#### 答：

JDBC连接的步骤如下：

1. 加载数据库驱动
2. 获取数据库连接
3. 创建数据库操作对象
4. 执行SQL语句
5. 处理查询结果
6. 释放资源

### 3.什么是junit，如何使用？

#### 答：

JUnit是一个Java语言的单元测试框架，用于编写和运行重复的测试。JUnit是一个开源框架，可以用于编写和运行重复的测试。它是一个重要的测试工具，用于测试Java应用程序中的各种方法。JUnit提供了注解来标记测试方法，JUnit测试用例类不需要继承特定的类，只需要使用JUnit提供的注解即可。JUnit测试用例类中的方法必须使用@Test注解标注，JUnit会自动执行被@Test标注的方法。JUnit中的断言类用于判断测试的实际结果和预期结果是否一致。JUnit的断言类由org.junit.Assert类提供。JUnit的使用步骤如下：

1. 导入JUnit相关的jar包
2. 创建测试类
3. 创建测试方法
4. 使用JUnit提供的注解标记测试方法(@Test)
5. 使用断言类判断测试结果
6. 运行测试方法
7. 查看测试结果

### 4.创建一个表 t_customer，包含字段有 id name age birthday register_time，使用JDBC完成下面操作：

#### 1.往表中插入多条数据

```java
package com.DJI;

import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/18/19:10
 * @LastEditors: FallCicada
 * @: 無限進步
 */
public class JunitTest_hw {
    // 数据库连接四要素
    // 1. 驱动
    String driver = "com.mysql.cj.jdbc.Driver";
    // 2. 数据库地址
    String url = "jdbc:mysql://127.0.0.1:3306/jdbc_test";
    // 3. 用户名 - 写自己数据库的用户名
    String username = "fallcicada";
    // 4. 密码 - 写自己数据库的密码
    String password = "9572";
    // 获取数据库连接 并输出连接对象
//    ### 4.创建一个表 t_customer，包含字段有 id name age birthday register_time，使用JDBC完成下面操作：
//            #### 1.往表中插入多条数据
//            #### 2.查找2000.1.1前出生的客户信息
    @Test
    public void createTable() {
        Connection conn = null;
        Statement stmt = null;
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

            sql = "CREATE TABLE IF NOT EXISTS jdbc_test.t_customer (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(20), " +
                    "age INT, " +
                    "birthday DATE, " +
                    "register_time DATETIME)";
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
    }
}
```

#### 1.往表中插入多条数据

```java
@Test
    public void insertData() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. 注册驱动
            Class.forName(driver);
            // 2. 获取连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 3. 获取数据库操作对象
            stmt = conn.createStatement();
            // 4. 执行sql
            String sql = "INSERT INTO jdbc_test.t_customer (name, age, birthday, register_time) VALUES " +
                    "('张三', 20, '2000-01-01', '2024-11-18'), " +
                    "('李四', 21, '2000-01-02', '2024-11-18'), " +
                    "('王五', 22, '2000-01-03', '2024-11-18'), " +
                    "('赵六', 23, '2000-01-04', '2024-11-18'), " +
                    "('田七', 24, '2000-01-05', '2024-11-18')";
            // 5. 处理查询结果
            int count = stmt.executeUpdate(sql);
            // 输出受影响的行数
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

#### 2.查找2000.1.6前出生的客户信息

```java
@Test
public void selectData() {
    try {
        // 注册 MySQL JDBC 驱动
        Class.forName(driver);
        // 使用 try-with-resources 语句自动管理资源，确保在方法结束时关闭连接和语句对象
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            // 再次注册驱动（这里实际上是多余的，因为前面已经注册过一次）
            Class.forName(driver);
            // 定义 SQL 查询语句，选择生日在 2000-01-06 之前的客户信息
            String sql = "SELECT * FROM jdbc_test.t_customer WHERE birthday < '2000-01-06'";
            // 执行 SQL 查询并获取结果集
            ResultSet rs = stmt.executeQuery(sql);
            // 处理查询结果
            while (rs.next()) { // 遍历结果集中的每一行
                // 获取当前行的 ID
                int id = rs.getInt("id");
                // 获取当前行的名字
                String name = rs.getString("name");
                // 获取当前行的年龄
                int age = rs.getInt("age");
                // 获取当前行的生日
                String birthday = rs.getString("birthday");
                // 获取当前行的注册时间
                String registerTime = rs.getString("register_time");
                // 打印当前行的信息
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age +
                        ", Birthday: " + birthday + ", Register Time: " + registerTime);
            }
        } catch (Exception e) {
            // 捕获并打印异常堆栈信息
            e.printStackTrace();
        }
    } catch (ClassNotFoundException e) {
        // 如果找不到驱动类，抛出运行时异常
        throw new RuntimeException(e);
    }
}
```

##### 输出结果

```angular2html
ID: 1, Name: 张三, Age: 20, Birthday: 2000-01-01, Register Time: 2024-11-18 00:00:00
ID: 2, Name: 李四, Age: 21, Birthday: 2000-01-02, Register Time: 2024-11-18 00:00:00
ID: 3, Name: 王五, Age: 22, Birthday: 2000-01-03, Register Time: 2024-11-18 00:00:00
ID: 4, Name: 赵六, Age: 23, Birthday: 2000-01-04, Register Time: 2024-11-18 00:00:00
ID: 5, Name: 田七, Age: 24, Birthday: 2000-01-05, Register Time: 2024-11-18 00:00:00
ID: 6, Name: 张三, Age: 20, Birthday: 2000-01-01, Register Time: 2024-11-18 00:00:00
ID: 7, Name: 李四, Age: 21, Birthday: 2000-01-02, Register Time: 2024-11-18 00:00:00
ID: 8, Name: 王五, Age: 22, Birthday: 2000-01-03, Register Time: 2024-11-18 00:00:00
ID: 9, Name: 赵六, Age: 23, Birthday: 2000-01-04, Register Time: 2024-11-18 00:00:00
ID: 10, Name: 田七, Age: 24, Birthday: 2000-01-05, Register Time: 2024-11-18 00:00:00
ID: 11, Name: 张小年, Age: 20, Birthday: 2000-01-01, Register Time: 2001-11-18 00:00:00
```
