package com.dji.demo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @description: User实体类 实体属性采用驼峰命名法
 * @author: rendc
 * @create: 2024-11-27 10:58
 **/
@Data // get set toString equals hashCode
@NoArgsConstructor // 无参构造器
@AllArgsConstructor // 全参构造器
public class User implements Serializable {
  // 主键id
  private Integer id;
  // 用户名
  private String username;
  // 登录密码
  private String password;
  // 手机号
  private String phone;
  // 用户头像
  private String avatar;
  // 用户性别 0男 1女
  private String gender;
  // 用户状态 0正常 1禁用
  private Byte status;
  // 用户生日
  private LocalDate birthday;
  // 注册时间
  private LocalDateTime registerTime;
}
