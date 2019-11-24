package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);

    Admin selectInfo(String account);

    Admin selectToLogin(@Param("account") String account, @Param("password") String password);

    Admin selectByShiro(String account);

    List<Admin> selectAll();
    List<Admin> selectAll2();
    int updateByPrimaryKeySelective(Admin record);

    int updateByIdTostate(@Param("a_state") boolean a_state, @Param("a_id") int a_id);

    int updateByPrimaryKey(Admin record);

    int setAdminForLogin(Admin admin);
}