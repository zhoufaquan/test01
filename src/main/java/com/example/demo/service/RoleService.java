package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public  Role getInfo(int limited){
        return roleMapper.selectByLimited(limited);
    }
}
