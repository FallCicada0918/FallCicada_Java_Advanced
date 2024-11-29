package com.dji.demo;

import lombok.Data;

/**
 * @program: demo
 * @description: 图书的实体类
 * @author: rendc
 * @create: 2024-11-28 15:06
 **/
@Data
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String description;
    private String author;
    private String publisher;
    private Double price;
    private Integer storeNum; //库存数量
    private Integer status; //书籍状态 0：上架 1：下架
    private Integer categoryId; //所属类别id,该值必须为二级分类id
}
