package com.example.demo.mapper;

import com.example.demo.entity.Rj;
import org.springframework.stereotype.Repository;

@Repository
public interface RjMapper {
    int deleteByPrimaryKey(Integer rjId);

    int insert(Rj record);

    int insertSelective(Rj record);

    Rj selectByPrimaryKey(Integer rjId);

    int updateByPrimaryKeySelective(Rj record);

    int updateByPrimaryKey(Rj record);
}