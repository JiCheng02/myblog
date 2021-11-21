package com.xxxxx.myblog.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue
    //主键
    private Long id;
    //登录名
    private String login;
    //名字
    private String firstName;
    //姓氏
    private String lastName;
    //描述
    private String description;
}
