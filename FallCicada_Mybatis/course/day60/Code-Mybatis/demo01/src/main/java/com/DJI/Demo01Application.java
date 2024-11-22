package com.DJI;

import com.DJI.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.DJI.mapper.UserMapper;

import java.util.List;

@SpringBootApplication
public class Demo01Application {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testList(){
        List<User> users = userMapper.list();
        for (User u : users) {
            System.out.println(u);
        }
    }

}
