/*
 * @Description:书籍扩展类
 * 
 * @Author: rendc
 * 
 * @Date: 2024-11-28 15:20:53
 * 
 * @LastEditors: rendc
 * 
 * @LastEditTime: 2024-11-28 15:24:04
 */
package com.dji.demo.extend;


import com.dji.demo.Book;

import com.dji.demo.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookExtend extends Book {
  // 书籍的类目信息
  private Category category;

  @Override
  public String toString() {
    return super.toString() + ":" + category.toString();
  }

}