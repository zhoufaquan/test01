package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rId);

    Role selctByAccount(String account);

    Role selectByLimited(int limited);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}