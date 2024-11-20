package com.DJI;
/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/19/11:32
 * @LastEditors: FallCicada
 * @: 無限進步
 */
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DruidTest {
    //1. 加载配置文件
    Properties properties = new Properties();
    InputStream iStream = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
    @Test
    public void test(){
        //声明链接对象
        Connection conn = null;
        PreparedStatement pstmt=null;
        //声明结果对像
        ResultSet rs=null;
        try {
            properties.load(iStream);
            properties.forEach((k,v)->System.out.println(k+":"+v));
            //获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            conn=dataSource.getConnection();
            System.out.println("conn:"+conn);
            //获取操作对象
            String sql="select * from t_customer where id = ?";
            pstmt=conn.prepareStatement(sql);
            //设置sql语句中第一个参数值为2
            pstmt.setInt(1,2);
            //执行查询语句、
            rs=pstmt.executeQuery();
            List<User> userList= new ArrayList<>();
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("id");
                String password=rs.getString("password");
                int age=rs.getInt("age");
                User u=new User(id, name, password, age);
                System.out.println(u);
                userList.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}