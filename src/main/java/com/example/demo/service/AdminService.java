package com.example.demo.service;

import com.example.demo.aop.SystemControllerLog;
import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Pattern;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admin selectByPrimaryKey(Integer aId){
        return adminMapper.selectByPrimaryKey(aId);
    }

    public Admin selectToLogin(String account,String password){
        return adminMapper.selectToLogin(account,password);
    }

    public Date getDate(){
        Date date=new Date();
        date.getTime();
        return date;
    }

    @SystemControllerLog("用户登录")
    public void setAdminForLogin(Admin admin){
        admin.setaLst(admin.getaSt());
        admin.setaSt(getDate());
        admin.setaCount(admin.getaCount()+1);
        adminMapper.setAdminForLogin(admin);
    }
}
