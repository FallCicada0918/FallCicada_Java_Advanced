package com.DJI;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/20/17:32
 * @LastEditors: 86138
 * @: 無限進步
 */
/*
 * 需求：创建一个表 t_customer，包含字段有 `id` `name` `age` `birthday` `register_time`
 *
 *  (1)	往表中插入多条数据
 *  (2)	查找2000.1.1前出生的客户信息，解析查询结果
 *  (3)	将结果封装到Customer对象中，最后添加到一个List集合中
 */
public class MysqlTable {
    // 1. 驱动
    String driver = "com.mysql.cj.jdbc.Driver";
    // 2. 数据库地址
    String url = "jdbc:mysql://127.0.0.1:3306/jdbc_test";
    // 3. 用户名 - 写自己数据库的用户名
    String username = "fallcicada";
    // 4. 密码 - 写自己数据库的密码
    String password = "9572";
    // 获取数据库连接 并输出连接对象
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
    //插入数据
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
                    "('张三', 20, '1999-12-01', '2024-11-18'), " +
                    "('李四', 21, '1999-11-02', '2024-11-18'), " +
                    "('王五', 22, '1999-12-31', '2024-11-18'), " +
                    "('赵六', 23, '2000-01-04', '2024-11-18'), " +
                    "('田七', 24, '2000-01-05', '2024-11-18'), " +
                    "('张小年',22,'2003-01-23','2024-11-18') ";
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
    //查找2000.1.1前出生的客户信息
    @Test
    public void selectData() {
        try {
            // 注册 MySQL JDBC 驱动
            Class.forName(driver);
            // 使用 try-with-resources 语句自动管理资源，确保在方法结束时关闭连接和语句对象
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement()) {
                // 再次注册驱动
                Class.forName(driver);
                // 定义 SQL 查询语句，选择生日在 2000-01-01 之前的客户信息
                String sql = "SELECT * FROM jdbc_test.t_customer WHERE birthday < '2000-01-01'";
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
        }// 无需释放资源，try-with-resources 语句会自动关闭连接和语句对象
    }
    //(3) 将结果封装到Customer对象中，最后添加到一个List集合中
    @Test
    public void selectDataAndEncapsulate() {
        List<Customer> customers = new ArrayList<>();
        try {
            // 注册 MySQL JDBC 驱动
            Class.forName(driver);
            // 使用 try-with-resources 语句自动管理资源，确保在方法结束时关闭连接和语句对象
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement()) {
                // 定义 SQL 查询语句，选择生日在 2000-01-01 之前的客户信息
                String sql = "SELECT * FROM jdbc_test.t_customer WHERE birthday < '2000-01-01'";
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
                    // 封装到 Customer 对象中
                    Customer customer = new Customer(id, name, age, birthday, registerTime);
                    // 添加到 List 集合中
                    customers.add(customer);
                }
            } catch (Exception e) {
                // 捕获并打印异常堆栈信息
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // 如果找不到驱动类，抛出运行时异常
            throw new RuntimeException(e);
        }
        System.out.println("遍历集合并输出");
        // 打印封装后的客户信息
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
