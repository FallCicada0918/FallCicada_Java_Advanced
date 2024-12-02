package com.dji.demo.mapper.extend;

import com.dji.demo.extend.BookExtend;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: demo
 * @description: 图书映射接口
 * @author: Fallcicada
 * @create: 2024-11-28 15:08
 **/
@Mapper
public interface BookExtendMapper {

    BookExtend findByIdWithCategory(Integer bookId);

}
