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


    public void setAdminForLogin(int id,Date st,int count){

        Admin admin=new Admin();
        admin.setaId(id);
        admin.setaLst(st);
        admin.setaSt(getDate());
        admin.setaCount(count+1);
       int i= adminMapper.setAdminForLogin(admin);

    }
    public Admin getInfo(String account){
        return adminMapper.selectInfo(account);
    }
    public Admin getBean(String account){
        return adminMapper.selectByShiro(account);
    }
}
