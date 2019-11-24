package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
//Authority对应的是数据库表结构的视图
public class Authority extends Menu implements Serializable {
    private Integer jId;

    private Integer pid;

    private String jName;

    private String jUrl;

    private String jIcon;

    private Integer jShow;


}