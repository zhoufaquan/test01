package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@ToString
@Getter
@Setter
public class Role  implements Serializable{
    private Integer rId;

    private String rRole;

    private Integer rLimited;
   /* private Set<Authority> permissions = new HashSet<>();*/

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrRole() {
        return rRole;
    }

    public void setrRole(String rRole) {
        this.rRole = rRole == null ? null : rRole.trim();
    }

    public Integer getrLimited() {
        return rLimited;
    }

    public void setrLimited(Integer rLimited) {
        this.rLimited = rLimited;
    }

}