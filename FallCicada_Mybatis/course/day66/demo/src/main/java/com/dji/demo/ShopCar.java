package com.dji.demo;

import lombok.Data;

//购物车基础类，对应es_shopcar表
@Data
public class ShopCar {
  private Integer id;
  private Integer userId;
  private Integer bookId;
  private Integer num;
}

