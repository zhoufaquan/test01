package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);
    Admin selectInfo(String  account);
    Admin selectToLogin(@Param("account") String account,@Param("password")String password);

    Admin selectByShiro(String account);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    int setAdminForLogin(Admin admin);
}