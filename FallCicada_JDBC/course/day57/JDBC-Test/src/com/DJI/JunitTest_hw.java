package com.DJI;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

    // 插入数据
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
            String sql = "INSERT INTO jdbc_test.t_customer (name, age, birthday, register_time,username,password) VALUES " +
                    "('张三', 20, '2000-01-01', '2024-11-18','Zhang3','12345'),  " +
                    "('李四', 21, '2000-01-02', '2024-11-18','Lisi4','12345'),  " +
                    "('王五', 22, '2000-01-03', '2024-11-18','WangWu','12345'),  " +
                    "('赵六', 23, '2000-01-04', '2024-11-18','ZhaoLiu','12345'),  " +
                    "('田七', 24, '2000-01-05', '2024-11-18','TianQi','12345')," +
                    "('张小年', 24, '2000-01-05', '2024-11-18','FallCicada','9572') ";
            // 5. 处理查询结果
            int count = stmt.executeUpdate(sql);
            // 输出受影响的行数
            System.out.println("成功添加" + count + "行");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    //添加用户名和密码列
    @Test
    public void addColumn() {
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
            String sql = "ALTER TABLE jdbc_test.t_customer ADD COLUMN username VARCHAR(20), ADD COLUMN password VARCHAR(20)";
            // 5. 处理查询结果
            int count = stmt.executeUpdate(sql);
            // 输出受影响的行数
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
