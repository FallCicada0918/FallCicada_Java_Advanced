package com.dji.demo;

import com.dji.demo.extend.BookExtend;
import com.dji.demo.mapper.extend.BookExtendMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: demo
 * @description: 图书扩展类的测试类
 * @author: Fallcicada
 * @create: 2024-11-28 15:41
 **/
@SpringBootTest
public class BookExtendTest {

    @Autowired
    private BookExtendMapper bookExtendMapper;

    @Test
    public void testFindByIdWithCategory(){
        BookExtend bookExtend = bookExtendMapper.findByIdWithCategory(1);
        System.out.println(bookExtend);

    }

}
