package com.dji.demo;

import com.dji.demo.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 代表这个测试类已经将Spring的环境（IOC容器）进行了整合，
// 我们要测试的对象，就可以直接注入，然后测试
@SpringBootTest
class DemoApplicationTests {

  @Autowired // 从Spring的IOC容器中，获取类型是Mapper的对象并注入
  private CategoryMapper categoryMapper;


  @Test
  public void test() {
    System.out.println("hello,spring");
  }

  @Test
  public void testFindById() {
    Category category = categoryMapper.findById(2);
    System.out.println("category：" + category);
    System.out.println("查询成功");
  }

  @Test
  public void testFindByIdParent() {
    Category category = categoryMapper.findByIdParent(2);
    System.out.println("category：" + category);
    Category parentCategory = category.getParent();
    System.out.println("parentCategory：" + parentCategory);
    System.out.println("查询成功");
  }

  @Test
  public void testFindByIdNew() {
    Category category = categoryMapper.findByIdNew(2);
    System.out.println("category：" + category);
    System.out.println("findByIdNew查询成功");
  }

  @Test
  public void testFindAllCategories() {
    categoryMapper.findAllCategories();
  }

}
