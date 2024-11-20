package com.DJI;

import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/18/16:58
 * @LastEditors: FallCicada
 * @: 無限進步
 */
public class Jdbc {
    // 数据库连接四要素
    // 1. 驱动
    String driver = "com.mysql.cj.jdbc.Driver";
    // 2. 数据库地址
    String url = "jdbc:mysql://127.0.0.1:3306/briup";
    // 3. 用户名 - 写自己数据库的用户名
    String username = "fallcicada";
    // 4. 密码 - 写自己数据库的密码
    String password = "9572";
    // 获取数据库连接 并输出连接对象
    @Test
    public void getConnection() {
        Connection conn = null;
        try {
            // 1. 注册驱动
            Class.forName(driver);
            // 2. 获取连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 输出连接对象
            System.out.println(conn);
            //3. 获取数据库操作对象
            Statement stmt = conn.createStatement();
            //4. 执行sql
            String sql = "drop table if exists t_user";
            //5. 处理查询结果
            int count = stmt.executeUpdate(sql);
            // 输出受影响的行数
            System.out.println(count);
            //6. 释放资源
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //删除表
    // 删除表
    @Test
    public void dropTable() {
        // 数据库连接对象
        Connection conn = null;
        // 数据库操作对象
        Statement stmt = null;
        try {
            // 1. 加载驱动
            Class.forName(driver);
            // 2. 获取连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 3. 获取操作对象
            stmt = conn.createStatement();
            // 4. 执行sql语句
            //创建数据库表表名为t_user
            int row = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS t_users(id INT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(20),password VARCHAR(20))");
            int rows = stmt.executeUpdate("DROP TABLE IF EXISTS t_user");
            // 5. 处理结果
            System.out.println("返回结果rows：" + rows);
        } catch (Exception e) {
            // 释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        }
    }
}
