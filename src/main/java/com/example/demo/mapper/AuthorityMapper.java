package com.example.demo.mapper;

import com.example.demo.entity.Authority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer jId);

    List<Authority> selectByRole(int limited);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}