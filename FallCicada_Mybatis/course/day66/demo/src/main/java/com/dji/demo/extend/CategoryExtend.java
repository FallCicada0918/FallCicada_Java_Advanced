package com.dji.demo.extend;

import com.dji.demo.Category;

import java.util.List;

public class CategoryExtend extends Category {
  // 一级分类中包含二级分类
  private List<Category> categories;

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "CategoryExtend{" +
            "id=" + super.getId() +
            "name=" + super.getName() +
            "description=" + super.getDescription() +
            "parent_id=" + super.getParentId() +
            "categories=" + categories +
            "}";
  }
}