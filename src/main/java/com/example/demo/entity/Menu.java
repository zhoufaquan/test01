package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@Setter
@Getter
//Menu实体增加了存放子菜单的属性
public class Menu {
    private Integer jId;

    private Integer pid;

    private String jName;

    private String jUrl;

    private String jIcon;

    private Integer jShow;
    private List<Menu> childMenus;

}
