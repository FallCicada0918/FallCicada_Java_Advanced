package com.example.demo;

import lombok.Data;

/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/22/08:31
 * @LastEditors: 86138
 * @: 無限進步
 */
@Data
public class User {
       private Integer id;   //id（主键）
       private String name;  //姓名
       private Short age;
       //年龄
       private Short gender; //性别
       private String phone; //手机号

       //无参构造器
       public User() {

       }
       //有参构造器
       public User(Integer id, String name, Short age, Short gender, String phone) {
                this.id = id;
                this.name = name;
                this.age = age;
                this.gender = gender;
                this.phone = phone;
       }
       //getter和setter方法
       public Integer getId() {
              return id;
       }
       public void setId(Integer id) {
              this.id = id;
       }
       public String getName() {
              return name;
       }
       public void setName(String name) {
              this.name = name;
       }
       public Short getAge() {
              return age;
       }
       public void setAge(Short age) {
              this.age = age;
       }
       public Short getGender() {
              return gender;
       }
       public void setGender(Short gender) {
              this.gender = gender;
       }
}
