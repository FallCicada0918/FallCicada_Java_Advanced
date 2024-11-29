/*
 * @Description: 
 * @Author: rendc
 * @Date: 2024-11-29 10:40:09
 * @LastEditors: rendc
 * @LastEditTime: 2024-11-29 10:41:37
 */
package com.dji.demo;

import com.dji.demo.extend.BookShopCarExtend;
import com.dji.demo.extend.UserShopCarExtend;
import com.dji.demo.mapper.ShopCarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @program: demo
 * @description: 图书扩展类的测试类
 * @author: fallcicada
 * @create: 2024-11-28 15:41
 **/
@SpringBootTest
public class ShopCarTest {

  @Autowired
  private ShopCarMapper shopCarMapper;

  @Test
  public void testInsertShopCar() {
    shopCarMapper.insertShopCar(1,1,1);
    System.out.println("添加购物车成功");

  }
  @Test
  public  void testfindBooksByUserId(){
    List<BookShopCarExtend> bookShopCarExtends = shopCarMapper.findBooksByUserId(1);
    for (BookShopCarExtend bookShopCarExtend : bookShopCarExtends) {
      System.out.println(bookShopCarExtend);
    }
  }

  @Test
  public void testFindUserByIdReset(){
    UserShopCarExtend shopCarExtend = shopCarMapper.findUserByIdReset(2);
    System.out.println(shopCarExtend);
  }

}
