package com.dji.demo.extend;

import com.dji.demo.Book;

public class BookShopCarExtend extends Book {
  // 用户购物车中，指定id书籍的数量
  private Integer num;

  @Override
  public String toString() {
    return "BookShopCarExtend{id=" +
        super.getId() + ", name=" +
        super.getName() + ", description=" +
        super.getDescription() + ", price=" +
        super.getPrice() + ", status=" +
        super.getStatus() + ", num=" + num +
        '}';
  }
}