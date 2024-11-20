package com.DJI;
/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/19/11:32
 * @LastEditors: FallCicada
 * @: 無限進步
 */
import org.junit.Test;

import java.sql.*;

public class PreparedStatementTest {
    // 数据库连接四要素
    // 1. 驱动
    String driver = "com.mysql.cj.jdbc.Driver";
    // 2. 数据库地址
    String url = "jdbc:mysql://127.0.0.1:3306/briup";
    // 3. 用户名 - 写自己数据库的用户名
    String username = "fallcicada";
    // 4. 密码 - 写自己数据库的密码
    String password = "9572";

    // 登录
    @Test
    public void login() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1. 加载驱动
            Class.forName(driver);
            // 2. 获取连接对象
            conn = DriverManager.getConnection(url, username, password);
            // 3. 获取操作对象
            // 用户输入的内容
            int userId = 1;
            // 用户输入的内容
            String userPwd = "'or '1'='1";
            String sql = "select count(*) from t_customer where id = ? and password = ?";
            // String sql = "select count(*) from t_user where id=1 and password='tom'";
            System.out.println("sql:" + sql);
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setInt(1, 1);
            pstmt.setString(2, "tom");
            // 4. 执行sql语句
            rs = pstmt.executeQuery(); // 注意这里执行的是查询语句
            // 5. 处理结果
            while (rs.next()) {
                // 返回值是数值
                int count = rs.getInt(1);
                System.out.println("count: " + count);
                if (count == 0) {
                    System.out.println("登录失败");
                } else {
                    System.out.println("登录成功");
                }
            }
        } catch (Exception e) {
            // 6. 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
    }

}
