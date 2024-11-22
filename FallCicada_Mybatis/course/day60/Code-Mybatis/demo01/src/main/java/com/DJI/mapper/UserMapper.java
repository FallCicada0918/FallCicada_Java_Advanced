package com.DJI.mapper;
import com.DJI.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/21/19:18
 * @LastEditors: 86138
 * @: 無限進步
 */
public class UserMapper {
    //查询所有用户数据
    @Select("select id, name, age, gender, phone from t_user")
    public List<User> list();
}
