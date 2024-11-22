package com.DJI;

/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/21/19:08
 * @LastEditors: 86138
 * @: 無限進步
 */

import lombok.Data;

@Data
public class User {
    private Integer id;   //id（主键）
    private String name;  //姓名
    private Short age;//年龄
    private Short gender; //性别
    private String phone; //手机号
    //无参构造器
    public User() {
    }
    //有参构造器
    public User(Integer id, String name, Short age,Short gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
    //getter和setter方法
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(Short age) {
        this.age = age;
    }
    public Short getAge() {
        return age;
    }
    public void setGender(Short gender){
        this.name = name;
    }
    public Short getGender() {
        return gender;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    //重写toString方法
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + ';';
    }
}