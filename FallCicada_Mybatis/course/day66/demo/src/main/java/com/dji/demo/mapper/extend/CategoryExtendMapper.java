package com.dji.demo.mapper.extend;

import com.dji.demo.extend.CategoryExtend;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: demo
 * @description: 分类扩展类接口
 * @author: rendc
 * @create: 2024-11-29 08:58
 **/
@Mapper
public interface CategoryExtendMapper {
  // 如果查询的是一级分类 则要包含所有的子分类
   CategoryExtend findByIdWithResult(Integer categoryId);
}
