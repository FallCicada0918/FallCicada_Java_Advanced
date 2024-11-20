package com.DJI;

/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/20/18:59
 * @LastEditors: 86138
 * @: 無限進步
 */
public class Customer {
    private int id;
    private String name;
    private int age;
    private String birthday;
    private String register_time;
    public Customer() {
    }
    public Customer(int id, String name, int age, String birthday, String register_time) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.register_time = register_time;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", register_time='" + register_time + '\'' +
                '}';
    }
}
