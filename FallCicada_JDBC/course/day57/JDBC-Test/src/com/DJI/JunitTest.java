package com.DJI;/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/18/16:45
 * @LastEditors: FallCicada
 * @: 無限進步
 */
import org.junit.Test;

public class JunitTest {
    public static void main(String[] args) {
        System.out.println("hello Junit");
    }
    //  @Test 该注解表明这个方法是测试方法
//  测试方法必须是公共的的、必须是无参数的无返回值的非静态的
    @Test
    public void test(){
        System.out.println("hello Junit");
    }
}
