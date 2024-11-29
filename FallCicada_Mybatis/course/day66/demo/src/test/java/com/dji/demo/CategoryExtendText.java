package com.dji.demo;

import com.dji.demo.extend.CategoryExtend;
import com.dji.demo.mapper.extend.CategoryExtendMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: demo
 * @description: 类目扩展测试类
 * @author: rendc
 * @create: 2024-11-29 09:23
 **/
@SpringBootTest
public class CategoryExtendText   {
    @Autowired
    private CategoryExtendMapper categoryExtendMapper;

    @Test
    public void testFindByIdWithCategory(){
        CategoryExtend categoryExtend = categoryExtendMapper.findByIdWithResult(1);
        System.out.println(categoryExtend);
    }


}
