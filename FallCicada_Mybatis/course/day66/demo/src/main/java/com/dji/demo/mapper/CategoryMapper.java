/*
 * @Description: 
 * @Author: rendc
 * @Date: 2024-11-27 11:13:29
 * @LastEditors: rendc
 * @LastEditTime: 2024-11-28 12:15:03
 */
package com.dji.demo.mapper;

import com.dji.demo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: demo
 * @description: UserMapper接口
 * @author: rendc
 * @create: 2024-11-27 11:13
 **/
// 在程序运行时 框架会自动生成接口的实现类对象，
// 并交给spring的IOC容器管理
@Mapper // 表示这个是MyBatis中的Mapper接口
public interface CategoryMapper {

  Category findById(Integer id);

  Category findByIdParent(Integer id);

  Category findByIdNew(Integer id);

  List<Category> findAllCategories();

}
