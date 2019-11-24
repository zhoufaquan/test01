package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@ToString
@Setter
@Getter
public class Exam {
    private Integer eId;

    private String eName;

    private String eBackground;

    private Date eStart;

    private Date eEnd;

    private Date eBegin;

    private Date eShutdown;

    private Integer eState;

    private String eRemark;


}