/*
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-11-28 10:23:47
 * @LastEditors: Fallcicada
 * @LastEditTime: 2024-11-28 12:05:16
 */
package com.dji.demo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @description: Category实体类 实体属性采用驼峰命名法
 * @author: Fallcicada
 * @create: 2024-11-27 10:58
 **/
@Data // get set toString equals hashCode
@NoArgsConstructor // 无参构造器
@AllArgsConstructor // 全参构造器
public class Category implements Serializable {
  // 主键id
  private Integer id;
  private String name;
  private String description;
  private Integer parentId; // 父类别id
  private Category parent; // 父分类
}
