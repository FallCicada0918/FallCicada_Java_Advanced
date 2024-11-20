package com.DJI;
import org.junit.Test;
/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/20/17:25
 * @LastEditors: 86138
 * @: 無限進步
 */
/*
 * 需求：创建一个表 t_customer，包含字段有 `id` `name` `age` `birthday` `register_time`
 *
 *  (1)	使用idea创建一个maven项目，项目名为maven_homework
 *  (2)	在项目中新建HelloWorld类，新建main方法，在控制台输出”hello,world”
 *  (3)	在项目中新建HelloWorld类，使用junit的单元测试功能在控制台输出”hello,maven”
 *  (4) 在项目中安装mysql-connector-java依赖，完成第4题
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.printf("hello,world");
    }
    @Test
    public void helloMaven(){
        System.out.printf("hello,maven");
    }
}