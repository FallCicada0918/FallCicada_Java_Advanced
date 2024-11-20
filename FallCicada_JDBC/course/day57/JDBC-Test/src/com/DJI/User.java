package com.DJI;

public class User {

    private int id;
    private String name;
    private String password;
    private int age;
    public User(){
    }
    public User(int id,String name,String password,int age){
        this.age=age;
        this.id=id;
        this.name=name;
        this.password=password;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Use [id="+id+",name="+name+",age="+age+",password="+password+"]";
    }

}