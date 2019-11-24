package com.example.demo.entity;

import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@ToString
public class Rj  {
    private Integer rjId;

    private Integer rId;

    private Integer jId;

    /*权限*/


    public Integer getRjId() {
        return rjId;
    }

    public void setRjId(Integer rjId) {
        this.rjId = rjId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }
}